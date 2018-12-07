package org.jzen.invoicing.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InvoiceSummaryBean {

	private String invoiceNumber;
	private String clientName;
	private String contractName;
	private String invoiceDate;
	private String sentDate;
	private String sendMethod;
	private String invoiceStatus;
	private String isManual;
	private BigDecimal totalVatSummary;
	private BigDecimal totalNetSummary;
	private BigDecimal totalGrossSummary;
	private String poNumber;
	private String sapClientCode;
	private EntityAddressBean billingAddress;
	private String businessContact;
	private List<InvoiceLineItemsBean> involicelineitems;
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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
	public String getSentDate() {
		return sentDate;
	}
	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}
	public String getSendMethod() {
		return sendMethod;
	}
	public void setSendMethod(String sendMethod) {
		this.sendMethod = sendMethod;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	
	public String getIsManual() {
		return isManual;
	}
	public void setIsManual(String isManual) {
		this.isManual = isManual;
	}
	public BigDecimal getTotalVatSummary() {
		return totalVatSummary;
	}
	public void setTotalVatSummary(BigDecimal totalVatSummary) {
		this.totalVatSummary = totalVatSummary;
	}
	public BigDecimal getTotalNetSummary() {
		return totalNetSummary;
	}
	public void setTotalNetSummary(BigDecimal totalNetSummary) {
		this.totalNetSummary = totalNetSummary;
	}
	public BigDecimal getTotalGrossSummary() {
		return totalGrossSummary;
	}
	public void setTotalGrossSummary(BigDecimal totalGrossSummary) {
		this.totalGrossSummary = totalGrossSummary;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getSapClientCode() {
		return sapClientCode;
	}
	public void setSapClientCode(String sapClientCode) {
		this.sapClientCode = sapClientCode;
	}
	public EntityAddressBean getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(EntityAddressBean billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getBusinessContact() {
		return businessContact;
	}
	public void setBusinessContact(String businessContact) {
		this.businessContact = businessContact;
	}
	public List<InvoiceLineItemsBean> getInvolicelineitems() {
		return involicelineitems;
	}
	public void setInvolicelineitems(List<InvoiceLineItemsBean> involicelineitems) {
		this.involicelineitems = involicelineitems;
	}
	
	
	
	
	
	
	
}
