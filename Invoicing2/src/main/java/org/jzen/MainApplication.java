package org.jzen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableCaching
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages= {"org.jzen"})
public class MainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
	
		SpringApplication.run(MainApplication.class);
		

	}  

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}


	

}
