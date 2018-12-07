package org.jzen.invoicing.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.invoicing.config.PersistenceConfig;
import org.jzen.invoicing.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {WebSecurityConfig.class,PersistenceConfig.class})
public class CurrentInvoiceReposTest {

	@Autowired
	CurrentInvoicesRepository currentRepos;
	

	@Test
	public void checkPagedQueries() {
		
		//int count=currentRepos.countPagedInvoices();
		//System.out.println(count);
	}
	
	
}
