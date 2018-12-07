package org.jzen.invoicing.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.invoicing.bean.InvoiceRunDatesBean;
import org.jzen.invoicing.entity.InvoiceRunDates;
import org.jzen.invoicing.repository.InvoiceRunRepository;
import org.jzen.invoicing.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnit44Runner;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnit44Runner.class)
public class InvoiceRunServiceImplTest {
	
	@Mock
	InvoiceRunRepository invoiceRunRepositoryMock;
	
	@InjectMocks
	private InvoiceRunServiceImpl invoiceRunServiceImpl;
	
	private List<InvoiceRunDates> getDatesList(){
		List<InvoiceRunDates> invoiceRunDatesList=new ArrayList<InvoiceRunDates>();
		InvoiceRunDates invDate=new InvoiceRunDates();
		invDate.setId(new Long(1));
		invDate.setInvoicePeriodEndDate(new Date("01/09/1989"));
		invDate.setInvoicePeriodStartDate(new Date("01/08/1989"));
		invDate.setRunStatus(true);
		invoiceRunDatesList.add(invDate);
		
		invDate=new InvoiceRunDates();
		invDate.setId(new Long(2));
		invDate.setInvoicePeriodEndDate(new Date("01/10/1989"));
		invDate.setInvoicePeriodStartDate(new Date("02/09/1989"));
		invDate.setRunStatus(true);
		invoiceRunDatesList.add(invDate);
		
		invDate=new InvoiceRunDates();
		invDate.setId(new Long(1));
		invDate.setInvoicePeriodEndDate(new Date("01/11/1989"));
		invDate.setInvoicePeriodStartDate(new Date("02/10/1989"));
		invDate.setRunStatus(true);
		invoiceRunDatesList.add(invDate);
		
		return invoiceRunDatesList;
	}
	
	@Test
	public void getAllInvoiceRunDates() {
		
	
		when(invoiceRunRepositoryMock.getAllPendingNextRunDates()).thenReturn(getDatesList());
		InvoiceRunDates invDate=new InvoiceRunDates();
		invDate.setId(new Long(1));
		invDate.setInvoicePeriodEndDate(new Date("01/09/1989"));
		invDate.setInvoicePeriodStartDate(new Date("01/08/1989"));
		invDate.setRunStatus(true);
		
		
		
		List<InvoiceRunDatesBean> resultBean= invoiceRunServiceImpl.getAllInvoiceRunDates();
		
		assertEquals(3,resultBean.size());
		
	};


}
