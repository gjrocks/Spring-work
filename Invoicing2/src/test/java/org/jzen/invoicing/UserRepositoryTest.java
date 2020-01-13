package org.jzen.invoicing;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.MainApplication;
import org.jzen.invoicing.entity.UserDetail;
import org.jzen.invoicing.repository.CurrentInvoicesRepository;
import org.jzen.invoicing.repository.UserRepository;
import org.jzen.invoicing.util.DateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
//@ContextConfiguration(classes= {org.jzen.invoicing.MainApplication.class,WebSecurityConfig.class,PersistenceConfig.class})
@WebAppConfiguration
@SpringBootTest(classes=MainApplication.class,properties= {"server.port=7000"})

//@TestPropertySource(properties= {"application.properties"})
public class UserRepositoryTest {
	
	
	@Autowired
	private UserRepository userRepository;
	/*@Autowired
	private TestEntityManager entityManager;*/
@Autowired
CurrentInvoicesRepository currentInvoicesRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void checkCurrentInvoiceRepos() {
		//int count= currentInvoicesRepository.countPagedInvoices();
		//System.out.println(count);
		///System.out.println(currentInvoicesRepository.getPagedInvoices("od_createdon", "desc", 1, 2));
		//System.out.println(currentInvoicesRepository.findOne(3L));
	}
	  
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
		userDetail.setUsername("demo11");
		userDetail.setPassword(passwordEncoder.encode("12345"));
		userDetail.setAuthority("ROLE_ADMIN");
		userDetail.setCreatedDate(new Date());
		userDetail.setEmail("dem11o@ganesh.com");
		userDetail.setEnabled(true);
		userRepository.save(userDetail);
		System.out.println(passwordEncoder.encode("12345"));
		System.out.println(passwordEncoder.encode("12345"));
	}
}
