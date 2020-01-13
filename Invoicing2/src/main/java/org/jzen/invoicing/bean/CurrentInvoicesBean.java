package org.jzen.invoicing.bean;

import java.util.Map;

import org.jzen.invoicing.validator.CheckInvoiceNumRangeConstraint;
import org.jzen.invoicing.validator.CurrentInvoicesDatePeriodConstraint;
import org.jzen.invoicing.validator.DateRangeConstraints;
import org.jzen.invoicing.validator.SentDateRangeConstraints;

@DateRangeConstraints(start="fromDate",end="toDate",message="To Date should be greater than From Date")
@SentDateRangeConstraints(start="fromSentDate",end="toSentDate",message="To Sent Date should be greater than From Sent Date")
@CurrentInvoicesDatePeriodConstraint(start="fromDate",end="toDate",message="Please select dates from current invoicing period.")
@CheckInvoiceNumRangeConstraint(invNum="invoiceNumSearch",invNumTo="invoiceNumToSearch",invNumFrom="invoiceNumFromSearch",message="Please search for an invoice number or range of invoice numbers, you cannot search for both.")

public class CurrentInvoicesBean {
	
	private String clientSearch;
	private String contractSearch;
	private String invoiceNumSearch;
	
	
	private String invoiceNumFromSearch;
	private String invoiceNumToSearch;
	private String toDate;
	private String fromDate;
	
	private String currentPeriodStart;
	
	private int page=0;
	private int displaySize;
	
	
	private Integer invoiceStatus;
	private String paymentMethod;
	private String sendMethod;
	private String toSentDate;
	private String fromSentDate;
	private String sapNumber;
	private String sortBy;
	
	private Map<String,String> sortByMap;
	
	private Map<Integer,String> invoiceStatusMap;
	
	
	

	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public Map<String, String> getSortByMap() {
		return sortByMap;
	}
	public void setSortByMap(Map<String, String> sortByMap) {
		this.sortByMap = sortByMap;
	}
	public Map<Integer, String> getInvoiceStatusMap() {
		return invoiceStatusMap;
	}
	public void setInvoiceStatusMap(Map<Integer, String> invoiceStatusMap) {
		this.invoiceStatusMap = invoiceStatusMap;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
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
	public String getToSentDate() {
		return toSentDate;
	}
	public void setToSentDate(String toSentDate) {
		this.toSentDate = toSentDate;
	}
	public String getFromSentDate() {
		return fromSentDate;
	}
	public void setFromSentDate(String fromSentDate) {
		this.fromSentDate = fromSentDate;
	}
	public String getSapNumber() {
		return sapNumber;
	}
	public void setSapNumber(String sapNumber) {
		this.sapNumber = sapNumber;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}
	
	public String getCurrentPeriodStart() {
		return currentPeriodStart;
	}
	public void setCurrentPeriodStart(String currentPeriodStart) {
		this.currentPeriodStart = currentPeriodStart;
	}
	public String getClientSearch() {
		return clientSearch;
	}
	public void setClientSearch(String clientSearch) {
		this.clientSearch = clientSearch;
	}
	public String getContractSearch() {
		return contractSearch;
	}
	public void setContractSearch(String contractSearch) {
		this.contractSearch = contractSearch;
	}
	public String getInvoiceNumSearch() {
		return invoiceNumSearch;
	}
	public void setInvoiceNumSearch(String invoiceNumSearch) {
		this.invoiceNumSearch = invoiceNumSearch;
	}
	public String getInvoiceNumFromSearch() {
		return invoiceNumFromSearch;
	}
	public void setInvoiceNumFromSearch(String invoiceNumFromSearch) {
		this.invoiceNumFromSearch = invoiceNumFromSearch;
	}
	public String getInvoiceNumToSearch() {
		return invoiceNumToSearch;
	}
	public void setInvoiceNumToSearch(String invoiceNumToSearch) {
		this.invoiceNumToSearch = invoiceNumToSearch;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	
	
	
	
	

}

