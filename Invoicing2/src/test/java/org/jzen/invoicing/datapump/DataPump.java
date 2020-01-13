package org.jzen.invoicing.datapump;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.MainApplication;
import org.jzen.invoicing.entity.Invoice;
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
public class DataPump {
	
	
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
		//System.out.println(currentInvoicesRepository.getPagedInvoices("od_createdon", "desc", 1, 2));
		Invoice invoice= null; //currentInvoicesRepository.findOne(3L);
		
		for(int ii=0;ii<200;ii++) {
		invoice.setId(null);
		invoice.setClient(RandomStringUtils.randomAlphabetic(10));
		//invoice.setContract(RandomStringUtils.randomAlphabetic(10));
		invoice.setSentDate(new Date());
		//invoice.setSapFileId((long)ii);
		String val=RandomUtils.nextInt(99999999)+"";
		for( int i=val.length();i<8;i++) {
			val="0"+val;
		}
		invoice.setInvoiceNum("R"+val);
		//R00001239
		currentInvoicesRepository.save(invoice);
		}
	}
	
//	@Test
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
		userDetail.setPassword(passwordEncoder.encode("demo11"));
		userDetail.setAuthority("ROLE_ADMIN");
		userDetail.setCreatedDate(new Date());
		userDetail.setEmail("dem11o@ganesh.com");
		userDetail.setEnabled(true);
		userRepository.save(userDetail);
	}
}
