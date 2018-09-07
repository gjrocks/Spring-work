package com.gj;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
/*@ContextConfiguration(locations = { "classpath:InvoiceApp-servlet.xml", "classpath:spring-basic-context.xml",
		"classpath:spring-data-persistence-context.xml", "classpath:spring-security-context.xml" })*/
@WebAppConfiguration
public class EbulktempApplicationTests {

	private ApplicationContext applicationContext;

	private boolean loadContext = true;
	
	  private MockMvc mockMvc;

	private String[] springConfig = { 
			"src/main/webapp/WEB-INF/spring-basic-context.xml", "src/main/webapp/WEB-INF/spring-data-persistence-context.xml",
			"src/main/webapp/WEB-INF/spring-security-context.xml" };

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Before
	public void setUp() throws Exception {

		if (loadContext) {
			applicationContext = new FileSystemXmlApplicationContext(springConfig);
		}
		
		// mockMvc = MockMvcBuilders.webApplicationContextSetup(applicationContext).build();
	}

	//@Resource
	PasswordEncoder passwordEncoder;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPasswordEncoder() {
		passwordEncoder=(PasswordEncoder)applicationContext.getBean("passwordEncoder");
		assertNotNull(passwordEncoder);
	}

}
