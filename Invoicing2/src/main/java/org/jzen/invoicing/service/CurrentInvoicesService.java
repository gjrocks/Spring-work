package org.jzen.invoicing.service;

import java.util.List;
import java.util.Map;

import org.jzen.invoicing.bean.CurrentInvoicesBean;
import org.jzen.invoicing.bean.CurrentInvoicesResultsBean;
import org.jzen.invoicing.datatable.PagingData;
import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.entity.InvoiceRunDates;
import org.springframework.data.domain.Page;


public interface CurrentInvoicesService {
	
	public Page<Invoice>  searchInvoices(CurrentInvoicesBean currentInvoicesSearchBean);

	InvoiceRunDates getCurrentPeriod();
		
	public PagingData    getPagedInvoices(CurrentInvoicesBean currentInvoicesSearchBean);
	
	public List<Invoice> getInvoicesByInvoiceNumList(List<String> invocieNumList);

	

}
