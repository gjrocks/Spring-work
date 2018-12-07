package org.jzen.invoicing.bean;


import org.jzen.invoicing.validator.InvoiceDateRunPeriodConstraints;

@InvoiceDateRunPeriodConstraints(start="invoicePeriodEndDate",end="prevInvoicePeriodEndDate",message="Invoice period end date can only be increased by maximum 10 days.")
public class InvoiceRunDatesBean {
	
	private String invoiceRunPeriod;
	private Long periodNum;
	private String invoicePeriodStartDate;
	private String invoicePeriodEndDate;
	private String prevInvoicePeriodStartDate;
	
	private String prevInvoicePeriodEndDate;
	
	
	
	public String getInvoiceRunPeriod() {
		return invoiceRunPeriod;
	}
	public void setInvoiceRunPeriod(String invoiceRunPeriod) {
		this.invoiceRunPeriod = invoiceRunPeriod;
	}
	public Long getPeriodNum() {
		return periodNum;
	}
	public void setPeriodNum(Long periodNum) {
		this.periodNum = periodNum;
	}
	public String getInvoicePeriodStartDate() {
		return invoicePeriodStartDate;
	}
	public void setInvoicePeriodStartDate(String invoicePeriodStartDate) {
		this.invoicePeriodStartDate = invoicePeriodStartDate;
	}
	public String getInvoicePeriodEndDate() {
		return invoicePeriodEndDate;
	}
	public void setInvoicePeriodEndDate(String invoicePeriodEndDate) {
		this.invoicePeriodEndDate = invoicePeriodEndDate;
	}
	
	public String getPrevInvoicePeriodEndDate() {
		return prevInvoicePeriodEndDate;
	}
	public void setPrevInvoicePeriodEndDate(String prevInvoicePeriodEndDate) {
		this.prevInvoicePeriodEndDate = prevInvoicePeriodEndDate;
	}
	public String getPrevInvoicePeriodStartDate() {
		return prevInvoicePeriodStartDate;
	}
	public void setPrevInvoicePeriodStartDate(String prevInvoicePeriodStartDate) {
		this.prevInvoicePeriodStartDate = prevInvoicePeriodStartDate;
	}

	
	
	
	
	

}
