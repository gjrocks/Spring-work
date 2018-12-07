package org.jzen.invoicing.repository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.invoicing.config.PersistenceConfig;
import org.jzen.invoicing.config.WebSecurityConfig;
import org.jzen.invoicing.entity.UserDetail;
import org.jzen.invoicing.util.DateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {WebSecurityConfig.class,PersistenceConfig.class})
public class UserRepositoryTest {
	
	
	@Autowired
	private UserRepository userRepository;
	/*@Autowired
	private TestEntityManager entityManager;*/

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Test
	public void saveUserTest() {

		UserDetail userDetail = new UserDetail("test","qwerty","test",true,"ADMIN",new Date());
	/*UserDetail userDetail = new UserDetail("test","qwerty","test",1,"ADMIN",0,new Date());
>>>>>>> branch '13.0_Branch' of https://bitbucket.org/capesol/ebulk/
		userDetail.setFailedAttempts(2);
		entityManager.persist(userDetail);
		entityManager.flush();
      
		UserDetail UserDetailfetched = userRepository.findByUsername("test");
		
		assertEquals("qwerty", UserDetailfetched.getEmail());
		
		int count=userRepository.getFailedAttemptsCount("test");
		assertEquals(2, count);*/
		//UserDetail userDetail=new UserDetail();
		userDetail.setDob(new DateWrapper(12,12,1980).getDate());
		userDetail.setUsername("demo");
		userDetail.setPassword(passwordEncoder.encode("demo"));
		userDetail.setAuthority("ROLE_ADMIN");
		userDetail.setCreatedDate(new Date());
		userDetail.setEmail("demo@ganesh.com");
		userDetail.setEnabled(true);
		userRepository.save(userDetail);
	}
}
