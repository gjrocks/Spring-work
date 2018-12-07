package org.jzen.invoicing.service;

import org.jzen.invoicing.bean.InvoiceSummaryBean;

public interface InvoiceSummaryService {
	
	public InvoiceSummaryBean getInvoiceSummaryByInvoiceNumber(String invoiceNumber);

}
