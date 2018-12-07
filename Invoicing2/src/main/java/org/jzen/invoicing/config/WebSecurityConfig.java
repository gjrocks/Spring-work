package org.jzen.invoicing.config;

import javax.sql.DataSource;

import org.jzen.invoicing.security.CustomLogoutHandler;
import org.jzen.invoicing.serviceImpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Autowired
	  private DataSource dataSource;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/js/**","/css/**","/images/**").permitAll() 
				.antMatchers("/login**").permitAll()//login link will be directly allowed
				.antMatchers("/forgotPassword*").permitAll()
				.antMatchers("/emailPassword*").permitAll()
				
				.antMatchers("/user/**").hasAuthority("ROLE_ADMIN")
				.antMatchers("/invoice/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()//all the requests should be authenticated
				.and().formLogin()
				.loginPage("/login").permitAll() // login page
				.defaultSuccessUrl("/currentInvoices") //dashboard page
				.failureHandler(new CustomAuthFailureHandler())			
				.and().logout().permitAll()
				.logoutSuccessUrl("/login?logout").
				deleteCookies("JSESSIONID").clearAuthentication(true)
				.invalidateHttpSession(true).logoutSuccessHandler(getCustomLogOutHandler())
				
				.and().sessionManagement()
				//.invalidSessionUrl("/sessionExpired")(don't use it -https://docs.spring.io/spring-security/site/docs/3.1.x/reference/springsecurity-single.html#ns-session-mgmt
				.maximumSessions(1)
				.maxSessionsPreventsLogin(false)   //setting it to true , causes login faliure(invalid credentials)
	        	.expiredUrl("/login?sessionExpired") 
			;
	
	}
	
	 @Bean
	  public PersistentTokenRepository tokenRepository() {
	    JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
	    jdbcTokenRepositoryImpl.setDataSource(dataSource);
	    return jdbcTokenRepositoryImpl;
	  }

	@Bean
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}

	
	@Bean
	public CustomLogoutHandler getCustomLogOutHandler() {
		return new CustomLogoutHandler();
	}
	@Bean
	public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}


}
