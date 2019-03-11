package org.jzen.invoicing.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice_contract")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contract_id",nullable = false)
	private int id;
	
	@Column(name = "type")
	private String type;

	@Column(name = "departmentCount")
	private Integer departmentCount;

	@Column(name = "divisionCount")
	private Integer divisionCount;

	@Column(name = "account_mgr_id")
	private String accountManagerId;
	@Column(name = "address_1")
	private String address1;

	@Column(name = "address_2")
	private String address2;

	@Column(name = "address_3")
	private String address3;

	@Column(name = "address_4")
	private String address4;

	@Column(name = "address_5")
	private String address5;

	@Column(name = "address_6")
	private String address6;

	@Column(name = "address_7")
	private String address7;

	@Column(name = "backing_file")
	private boolean isBackingFile;

	@Column(name = "billing_entity")
	private String billibgEntity;

	@Column(name = "billing_event")
	private String event;

	@Column(name = "business_contact")
	private String businessContact;

	@Column(name = "client_SAP_code")
	private String clientSAPCode;

	@Column(name = "client_WBS_code")
	private String clientWBSCode;

	@Column(name = "client_code")
	private String clientCode;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "contract_name")
	private String contractName;

	@Column(name = "crm_id")
	private String crmId;

	@Column(name = "ctr_renewal_date")
	private Date ctrRenewalDate;

	@Column(name = "currency")
	private String currency;


	@Column(name = "data_retention_period")
	private Integer dataRetentionPeriod;

	@Column(name = "department_id")
	private String departmentId;


	@Column(name = "dept_num")
	private String departmentNumber;

	@Column(name = "division_id")
	private boolean IsDivisionId;

	@Column(name = "email_cc")
	private String emailCC;


	@Column(name = "email_to")
	private String emailTo;

	@Column(name = "end_date")
	private boolean isEndDate;

	@Column(name = "hidePriceOnCreate")
	private boolean isPriceHideOnCreate;

	@Column(name = "invoiceByDept")
	private Integer invoiceByDept;

	@Column(name = "invoice_cand_count_cutoff")
	private Integer invoiceCandCountCutOff;

	@Column(name = "invoice_day_of_month")
	private Integer invoiceDayOfMonth;

	@Column(name = "invoice_file")
	private boolean isInvoiceFile;

	@Column(name = "invoice_freq")
	private Integer invoiceFrequency;

	@Column(name = "invoice_method")
	private Integer invoiceMethod;

	@Column(name = "invoice_style")
	private Integer invoiceStyle;

	@Column(name = "last_invoice_date")
	private Date lastInvoiceDate;


	@Column(name = "name")
	private String name;

	@Column(name = "next_invoice_date")
	private Date nextInvoiceDate;

	@Column(name = "nominal_code")
	private String nominalCode;

	@Column(name = "od_createdby")
	private String odCreatedBy;

	@Column(name = "od_updatedby")
	private String odUpdatedBy;

	@Column(name = "od_createdon")
	private Date odCreatedOn;

	@Column(name = "od_updatedon")
	private Date odupdatedOn;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "payment_terms")
	private String paymentTerms;

	@Column(name = "reference")
	private String reference;


	@Column(name = "start_date")
	private boolean isStartDate;

	@Column(name = "status")
	private Integer status;

	@Column(name = "vat_applied")
	private boolean isVatApplied;

	@Column(name = "vat_rate")
	private BigDecimal vatRate;

	@Column(name = "vat_type")
	private String vatType;

	@Column(name = "vendor_number")
	private String vendorNumber;

	@Column(name = "volt_ref")
	private String voltRef;

	@Column(name = "volumeExpectedAnnually")
	private boolean isVolumeExpectedAnnualy;

	@Column(name = "volumeExpectedMonthly")
	private boolean isVolumeExpectedmonthly;

	@Column(name = "volumeExpectedWeekly")
	private boolean isVolumeExpectedWeekly;
	
	 @OneToMany(mappedBy = "contract")
    private List<Invoice> invoice;
	
	
	public List<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}

	public Contract(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDepartmentCount() {
		return departmentCount;
	}

	public void setDepartmentCount(Integer departmentCount) {
		this.departmentCount = departmentCount;
	}

	public Integer getDivisionCount() {
		return divisionCount;
	}

	public void setDivisionCount(Integer divisionCount) {
		this.divisionCount = divisionCount;
	}

	public String getAccountManagerId() {
		return accountManagerId;
	}

	public void setAccountManagerId(String accountManagerId) {
		this.accountManagerId = accountManagerId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getAddress6() {
		return address6;
	}

	public void setAddress6(String address6) {
		this.address6 = address6;
	}

	public String getAddress7() {
		return address7;
	}

	public void setAddress7(String address7) {
		this.address7 = address7;
	}

	public boolean isBackingFile() {
		return isBackingFile;
	}

	public void setBackingFile(boolean isBackingFile) {
		this.isBackingFile = isBackingFile;
	}

	public String getBillibgEntity() {
		return billibgEntity;
	}

	public void setBillibgEntity(String billibgEntity) {
		this.billibgEntity = billibgEntity;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getBusinessContact() {
		return businessContact;
	}

	public void setBusinessContact(String businessContact) {
		this.businessContact = businessContact;
	}

	public String getClientSAPCode() {
		return clientSAPCode;
	}

	public void setClientSAPCode(String clientSAPCode) {
		this.clientSAPCode = clientSAPCode;
	}

	public String getClientWBSCode() {
		return clientWBSCode;
	}

	public void setClientWBSCode(String clientWBSCode) {
		this.clientWBSCode = clientWBSCode;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getCrmId() {
		return crmId;
	}

	public void setCrmId(String crmId) {
		this.crmId = crmId;
	}

	public Date getCtrRenewalDate() {
		return ctrRenewalDate;
	}

	public void setCtrRenewalDate(Date ctrRenewalDate) {
		this.ctrRenewalDate = ctrRenewalDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getDataRetentionPeriod() {
		return dataRetentionPeriod;
	}

	public void setDataRetentionPeriod(Integer dataRetentionPeriod) {
		this.dataRetentionPeriod = dataRetentionPeriod;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public boolean isIsDivisionId() {
		return IsDivisionId;
	}

	public void setIsDivisionId(boolean isDivisionId) {
		IsDivisionId = isDivisionId;
	}

	public String getEmailCC() {
		return emailCC;
	}

	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public boolean isEndDate() {
		return isEndDate;
	}

	public void setEndDate(boolean isEndDate) {
		this.isEndDate = isEndDate;
	}

	public boolean isPriceHideOnCreate() {
		return isPriceHideOnCreate;
	}

	public void setPriceHideOnCreate(boolean isPriceHideOnCreate) {
		this.isPriceHideOnCreate = isPriceHideOnCreate;
	}

	public Integer getInvoiceByDept() {
		return invoiceByDept;
	}

	public void setInvoiceByDept(Integer invoiceByDept) {
		this.invoiceByDept = invoiceByDept;
	}

	public Integer getInvoiceCandCountCutOff() {
		return invoiceCandCountCutOff;
	}

	public void setInvoiceCandCountCutOff(Integer invoiceCandCountCutOff) {
		this.invoiceCandCountCutOff = invoiceCandCountCutOff;
	}

	public Integer getInvoiceDayOfMonth() {
		return invoiceDayOfMonth;
	}

	public void setInvoiceDayOfMonth(Integer invoiceDayOfMonth) {
		this.invoiceDayOfMonth = invoiceDayOfMonth;
	}

	public boolean isInvoiceFile() {
		return isInvoiceFile;
	}

	public void setInvoiceFile(boolean isInvoiceFile) {
		this.isInvoiceFile = isInvoiceFile;
	}

	public Integer getInvoiceFrequency() {
		return invoiceFrequency;
	}

	public void setInvoiceFrequency(Integer invoiceFrequency) {
		this.invoiceFrequency = invoiceFrequency;
	}

	public Integer getInvoiceMethod() {
		return invoiceMethod;
	}

	public void setInvoiceMethod(Integer invoiceMethod) {
		this.invoiceMethod = invoiceMethod;
	}

	public Integer getInvoiceStyle() {
		return invoiceStyle;
	}

	public void setInvoiceStyle(Integer invoiceStyle) {
		this.invoiceStyle = invoiceStyle;
	}

	public Date getLastInvoiceDate() {
		return lastInvoiceDate;
	}

	public void setLastInvoiceDate(Date lastInvoiceDate) {
		this.lastInvoiceDate = lastInvoiceDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNextInvoiceDate() {
		return nextInvoiceDate;
	}

	public void setNextInvoiceDate(Date nextInvoiceDate) {
		this.nextInvoiceDate = nextInvoiceDate;
	}

	public String getNominalCode() {
		return nominalCode;
	}

	public void setNominalCode(String nominalCode) {
		this.nominalCode = nominalCode;
	}

	public String getOdCreatedBy() {
		return odCreatedBy;
	}

	public void setOdCreatedBy(String odCreatedBy) {
		this.odCreatedBy = odCreatedBy;
	}

	public String getOdUpdatedBy() {
		return odUpdatedBy;
	}

	public void setOdUpdatedBy(String odUpdatedBy) {
		this.odUpdatedBy = odUpdatedBy;
	}

	public Date getOdCreatedOn() {
		return odCreatedOn;
	}

	public void setOdCreatedOn(Date odCreatedOn) {
		this.odCreatedOn = odCreatedOn;
	}

	public Date getOdupdatedOn() {
		return odupdatedOn;
	}

	public void setOdupdatedOn(Date odupdatedOn) {
		this.odupdatedOn = odupdatedOn;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isStartDate() {
		return isStartDate;
	}

	public void setStartDate(boolean isStartDate) {
		this.isStartDate = isStartDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean isVatApplied() {
		return isVatApplied;
	}

	public void setVatApplied(boolean isVatApplied) {
		this.isVatApplied = isVatApplied;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public String getVendorNumber() {
		return vendorNumber;
	}

	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}

	public String getVoltRef() {
		return voltRef;
	}

	public void setVoltRef(String voltRef) {
		this.voltRef = voltRef;
	}

	public boolean isVolumeExpectedAnnualy() {
		return isVolumeExpectedAnnualy;
	}

	public void setVolumeExpectedAnnualy(boolean isVolumeExpectedAnnualy) {
		this.isVolumeExpectedAnnualy = isVolumeExpectedAnnualy;
	}

	public boolean isVolumeExpectedmonthly() {
		return isVolumeExpectedmonthly;
	}

	public void setVolumeExpectedmonthly(boolean isVolumeExpectedmonthly) {
		this.isVolumeExpectedmonthly = isVolumeExpectedmonthly;
	}

	public boolean isVolumeExpectedWeekly() {
		return isVolumeExpectedWeekly;
	}

	public void setVolumeExpectedWeekly(boolean isVolumeExpectedWeekly) {
		this.isVolumeExpectedWeekly = isVolumeExpectedWeekly;
	}
	
	
	
}
