package org.baeldung.test;

import java.util.Date;

import org.baeldung.config.AuthorizationServerApplication;
import org.baeldung.config.UserRepository;
import org.baeldung.model.UserDetail;
import org.baeldung.util.DateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

  
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes= {org.jzen.invoicing.MainApplication.class,WebSecurityConfig.class,PersistenceConfig.class})
@WebAppConfiguration
@SpringBootTest(classes=AuthorizationServerApplication.class,properties= {"server.port=7000"})

//@TestPropertySource(properties= {"application.properties"})
public class UserRepositoryTest {
	
	
	@Autowired
	private UserRepository userRepository;
	/*@Autowired
	private TestEntityManager entityManager;*/

	@Autowired
	private PasswordEncoder passwordEncoder;
	

	
	@Test
	public void saveUserTest() {

		//UserDetail userDetail = new UserDetail("test","qwerty","test",true,"ADMIN",new Date());
	/*UserDetail userDetail = new UserDetail("test","qwerty","test",1,"ADMIN",0,new Date());
>>>>>>> branch '13.0_Branch' of https://bitbucket.org/capesol/ebulk/
		userDetail.setFailedAttempts(2);
		entityManager.persist(userDetail);
		entityManager.flush();
       .withUser("tom").password("111").roles("ADMIN").and()
	  .withUser("user1").password("pass").roles("USER").and()
	  .withUser("admin").password("nimda").roles("ADMIN");
		UserDetail UserDetailfetched = userRepository.findByUsername("test");
		
		assertEquals("qwerty", UserDetailfetched.getEmail());
		
		int count=userRepository.getFailedAttemptsCount("test");
		assertEquals(2, count);*/
		UserDetail userDetail=new UserDetail();
		userDetail.setDob(new DateWrapper(12,12,1980).getDate());
		userDetail.setUsername("admin");
		userDetail.setPassword(passwordEncoder.encode("nimda"));
		userDetail.setAuthority("ADMIN");
		userDetail.setCreatedDate(new Date());
		userDetail.setEmail("admin@ganesh.com");
		userDetail.setEnabled(true);
		userRepository.save(userDetail);
	}
}
