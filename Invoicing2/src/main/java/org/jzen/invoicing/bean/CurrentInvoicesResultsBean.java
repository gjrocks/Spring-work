package org.jzen.invoicing.bean;

public class CurrentInvoicesResultsBean {
	
	private String invoiceNum;
	private String clientName;
	private String contractName;
	private String invoiceDate;
	private String paymentMethod;
	private String sendMethod;
	private String sentDate;
	private String sap;
	private String invoiceStatus;
	
	
	
	
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public String getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getSendMethod() {
		return sendMethod;
	}
	public void setSendMethod(String sendMethod) {
		this.sendMethod = sendMethod;
	}
	public String getSentDate() {
		return sentDate;
	}
	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}
	public String getSap() {
		return sap;
	}
	public void setSap(String sap) {
		this.sap = sap;
	}
	
	

}
