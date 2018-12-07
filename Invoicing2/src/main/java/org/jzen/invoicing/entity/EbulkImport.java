package org.jzen.invoicing.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="invoice_ebulkimport")
public class EbulkImport {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="urn",nullable = false)
	private long id;
	
	@Column(name = "SapClientCode")
	private String sapClientCode;
	
	@Column(name = "ApplicantForename")
	private String applicantForeName;
	
	
	@Column(name = "ApplicantSurname")
	private String applicantSurname;
	
	
	@Column(name = "ApplicationSentDate")
	private String applicationSentDate;
	
	
	@Column(name = "AppRef")
	private String appRef;
	
	
	@Column(name = "OrganisationReference")
	private String organisationReference;
	
	
	@Column(name = "OrganisationName")
	private String organisationName;
	
	
	@Column(name = "OrganisationPostcode")
	private String organisationPostcode;
	
	
	@Column(name = "ApplicantIsVolunteer")
	private String applicantIsVolunteer;
	

	
	@Column(name = "ApplicationChannel")
	private String applicationChannel;
	
	
	@Column(name = "ApplicationDisclosureType")
	private String applicationDisclosureType;
	 
	
	@Column(name = "ApplicationBasicFee")
	private BigDecimal applicationBasicFee;
	
	
	@Column(name = "ApplicationAdminFee")
	private BigDecimal applicationAdminFee;
	
	@Column(name = "ApplicationDBSAdultFirstFee")
	private BigDecimal applicationDBSAdultFirstFee;
	
	@Column(name = "ApplicationDBSAdultFirstAdminFee")
	private BigDecimal applicationDBSAdultFirstAdminFee;
	
	@Column(name = "ApplicationEnhancedFee")
	private BigDecimal applicationEnhancedFee;
	
	
	@Column(name = "ApplicationStandardFee")
	private BigDecimal  applicationStandardFee;
	
	@Column(name = "ApplicationPaymentCharge")
	private BigDecimal applicationPaymentCharge;
	
	@Column(name = "ApplicationPaymentChargeExempt")
	private BigDecimal ApplicationPaymentChargeExempt;
	
	@Column(name = "ApplicationVatFee")
	private BigDecimal applicationVatFee;
	
	@Column(name = "ApplicationTotalFee")
	private BigDecimal applicationTotalFee;
	
	@Column(name = "ApplicationVatExempt")
	private String applicationVatExempt;
	
	@Column(name = "ApplicationPaymentIndicator")
	private String applicationPaymentIndicator;
	
	@Column(name = "EbulkInvoiceUpdates")
	private String EbulkInvoiceUpdates;
	
	@Column(name = "ApplicationRepeatCheck")
	private String ApplicationRepeatCheck;
	
	@Column(name = "ApplicationCostCode")
	private String ApplicationCostCode;
	
	
	@Column(name = "OrganisationPurchaseOrderNumber")
	private String OrganisationPurchaseOrderNumber;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="FK_invoiceNum",referencedColumnName="invoice_num")
	private Invoice invoiceImport;
	
	

	public Invoice getInvoiceImport() {
		return invoiceImport;
	}


	public void setInvoiceImport(Invoice invoiceImport) {
		this.invoiceImport = invoiceImport;
	}


	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSapClientCode() {
		return sapClientCode;
	}


	public void setSapClientCode(String sapClientCode) {
		this.sapClientCode = sapClientCode;
	}


	public String getApplicantForeName() {
		return applicantForeName;
	}


	public void setApplicantForeName(String applicantForeName) {
		this.applicantForeName = applicantForeName;
	}


	public String getApplicantSurname() {
		return applicantSurname;
	}


	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}


	public String getApplicationSentDate() {
		return applicationSentDate;
	}


	public void setApplicationSentDate(String applicationSentDate) {
		this.applicationSentDate = applicationSentDate;
	}


	public String getAppRef() {
		return appRef;
	}


	public void setAppRef(String appRef) {
		this.appRef = appRef;
	}


	public String getOrganisationReference() {
		return organisationReference;
	}


	public void setOrganisationReference(String organisationReference) {
		this.organisationReference = organisationReference;
	}


	public String getOrganisationName() {
		return organisationName;
	}


	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}


	public String getOrganisationPostcode() {
		return organisationPostcode;
	}


	public void setOrganisationPostcode(String organisationPostcode) {
		this.organisationPostcode = organisationPostcode;
	}


	public String getApplicantIsVolunteer() {
		return applicantIsVolunteer;
	}


	public void setApplicantIsVolunteer(String applicantIsVolunteer) {
		this.applicantIsVolunteer = applicantIsVolunteer;
	}


	public String getApplicationChannel() {
		return applicationChannel;
	}


	public void setApplicationChannel(String applicationChannel) {
		this.applicationChannel = applicationChannel;
	}


	public String getApplicationDisclosureType() {
		return applicationDisclosureType;
	}


	public void setApplicationDisclosureType(String applicationDisclosureType) {
		this.applicationDisclosureType = applicationDisclosureType;
	}


	public BigDecimal getApplicationBasicFee() {
		return applicationBasicFee;
	}


	public void setApplicationBasicFee(BigDecimal applicationBasicFee) {
		this.applicationBasicFee = applicationBasicFee;
	}


	public BigDecimal getApplicationAdminFee() {
		return applicationAdminFee;
	}


	public void setApplicationAdminFee(BigDecimal applicationAdminFee) {
		this.applicationAdminFee = applicationAdminFee;
	}


	public BigDecimal getApplicationDBSAdultFirstFee() {
		return applicationDBSAdultFirstFee;
	}


	public void setApplicationDBSAdultFirstFee(BigDecimal applicationDBSAdultFirstFee) {
		this.applicationDBSAdultFirstFee = applicationDBSAdultFirstFee;
	}


	public BigDecimal getApplicationDBSAdultFirstAdminFee() {
		return applicationDBSAdultFirstAdminFee;
	}


	public void setApplicationDBSAdultFirstAdminFee(BigDecimal applicationDBSAdultFirstAdminFee) {
		this.applicationDBSAdultFirstAdminFee = applicationDBSAdultFirstAdminFee;
	}


	public BigDecimal getApplicationEnhancedFee() {
		return applicationEnhancedFee;
	}


	public void setApplicationEnhancedFee(BigDecimal applicationEnhancedFee) {
		this.applicationEnhancedFee = applicationEnhancedFee;
	}


	public BigDecimal getApplicationStandardFee() {
		return applicationStandardFee;
	}


	public void setApplicationStandardFee(BigDecimal applicationStandardFee) {
		this.applicationStandardFee = applicationStandardFee;
	}


	public BigDecimal getApplicationPaymentCharge() {
		return applicationPaymentCharge;
	}


	public void setApplicationPaymentCharge(BigDecimal applicationPaymentCharge) {
		this.applicationPaymentCharge = applicationPaymentCharge;
	}


	public BigDecimal getApplicationPaymentChargeExempt() {
		return ApplicationPaymentChargeExempt;
	}


	public void setApplicationPaymentChargeExempt(BigDecimal applicationPaymentChargeExempt) {
		ApplicationPaymentChargeExempt = applicationPaymentChargeExempt;
	}


	public BigDecimal getApplicationVatFee() {
		return applicationVatFee;
	}


	public void setApplicationVatFee(BigDecimal applicationVatFee) {
		this.applicationVatFee = applicationVatFee;
	}


	public BigDecimal getApplicationTotalFee() {
		return applicationTotalFee;
	}


	public void setApplicationTotalFee(BigDecimal applicationTotalFee) {
		this.applicationTotalFee = applicationTotalFee;
	}


	public String getApplicationVatExempt() {
		return applicationVatExempt;
	}


	public void setApplicationVatExempt(String applicationVatExempt) {
		this.applicationVatExempt = applicationVatExempt;
	}


	public String getApplicationPaymentIndicator() {
		return applicationPaymentIndicator;
	}


	public void setApplicationPaymentIndicator(String applicationPaymentIndicator) {
		this.applicationPaymentIndicator = applicationPaymentIndicator;
	}


	public String getEbulkInvoiceUpdates() {
		return EbulkInvoiceUpdates;
	}


	public void setEbulkInvoiceUpdates(String ebulkInvoiceUpdates) {
		EbulkInvoiceUpdates = ebulkInvoiceUpdates;
	}


	public String getApplicationRepeatCheck() {
		return ApplicationRepeatCheck;
	}


	public void setApplicationRepeatCheck(String applicationRepeatCheck) {
		ApplicationRepeatCheck = applicationRepeatCheck;
	}


	public String getApplicationCostCode() {
		return ApplicationCostCode;
	}


	public void setApplicationCostCode(String applicationCostCode) {
		ApplicationCostCode = applicationCostCode;
	}


	public String getOrganisationPurchaseOrderNumber() {
		return OrganisationPurchaseOrderNumber;
	}


	public void setOrganisationPurchaseOrderNumber(String organisationPurchaseOrderNumber) {
		OrganisationPurchaseOrderNumber = organisationPurchaseOrderNumber;
	}
	
	
	
	
	
}
