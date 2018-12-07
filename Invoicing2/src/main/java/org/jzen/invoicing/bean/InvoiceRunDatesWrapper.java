package org.jzen.invoicing.bean;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRunDatesWrapper {
	
	private List<InvoiceRunDatesBean> invoiceRunDatesList;

	public List<InvoiceRunDatesBean> getInvoiceRunDatesList() {
		return invoiceRunDatesList;
	}

	public void setInvoiceRunDatesList(List<InvoiceRunDatesBean> invoiceRunDatesList) {
		this.invoiceRunDatesList = invoiceRunDatesList;
	}
	
	public InvoiceRunDatesWrapper() {
        this.invoiceRunDatesList = new ArrayList<InvoiceRunDatesBean>();
   }

 

   public void add(InvoiceRunDatesBean invoiceRunDatesBean) {
       this.invoiceRunDatesList.add(invoiceRunDatesBean);
   }

}
