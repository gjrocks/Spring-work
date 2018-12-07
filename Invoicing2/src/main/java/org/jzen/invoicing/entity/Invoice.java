package org.jzen.invoicing.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;


@Entity
@Table(name="invoice_details")
public class Invoice implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="urn",nullable = false)
	private Long id;
	
	@Column(name="client_id",nullable = false)
	private String client;
	
	@Column(name="status")
	private Integer invoiceStatusValue;
	
	@NaturalId 
	@Column(name = "invoice_num")
	private String invoiceNum;

	@Column(name = "invoice_date")
	private Date invoiceDate;

	@Column(name = "line_manager")
	private String lineManager;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	Date endDate;

	@Column(name = "due_date")
	Date dueDate;


	@Column(name = "cancels_invoice")
	Integer cancelsInvoice;

	@Column(name = "authorised_by")
	Integer authorisedBy;

	@Column(name = "authorised_on")
	Date authorisedOn;

	@Column(name = "cancelled_by")
	Integer cancelledBy;

	@Column(name = "cancelled_on")
	Date cancelledOn;

	@Column(name = "paid_status")
	Integer paidStatus;

	@Column(name = "paid_date")
	Date paidDate;

	@Column(name = "sent_status")
	Integer sentStatus;

	@Column(name = "sent_date")
	Date sentDate;

	@Column(name = "net")
	BigDecimal net;

	@Column(name = "gross")
	BigDecimal gross;

	@Column(name = "vat")
	BigDecimal vat;

	@Column(name = "balance")
	BigDecimal balance;

	@Column(name = "currency")
	String currency;

	@Column(name = "period_start")
	Date periodStart;

	@Column(name = "period_end")
	Date periodEnd;

	@Column(name = "text")
	String text;

	@Column(name = "comments")
	String comments;

	@Column(name = "description")
	String description;

	@Column(name = "invoiceFile")
	String invoiceFile;

	@Column(name = "backingFile")
	String backingFile;

	@Column(name = "source_name")
	String sourceName;

	@Column(name = "source_building")
	String sourceBuilding;

	@Column(name = "source_street")
	String sourceStreet;

	@Column(name = "source_town")
	String sourceTown;

	@Column(name = "source_county")
	String sourceCounty;

	@Column(name = "source_postcode")
	String sourcePostcode;

	@Column(name = "source_country")
	String sourceCountry;

	@Column(name = "source_email")
	String sourceEmail;

	@Column(name = "target_name")
	String targetName;

	@Column(name = "target_building")
	String targetBuilding;

	@Column(name = "target_street")
	String targetStreet;

	@Column(name = "target_town")
	String targetTown;

	@Column(name = "target_county")
	String targetCounty;

	@Column(name = "target_postcode")
	String targetPostcode;

	@Column(name = "target_country")
	String targetCountry;

	@Column(name = "target_email")
	String targetEmail;

	@Column(name = "department")
	String department;

	@Column(name = "cost_code")
	String costCode;

	@Column(name = "od_status")
	Integer odStatus;

	@Column(name = "od_timestamp")
	String odTimestamp;

	@Column(name = "od_createdon")
	Date odCreatedon;

	@Column(name = "od_createdby")
	Integer odCreatedby;

	@Column(name = "od_updatedon")
	Date odUpdatedon;

	@Column(name = "od_updatedby")
	Integer odUpdatedby;

	@Column(name = "contract_name")
	private String contractName;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "payment_method")
	private Integer paymentMethod;
	
	@Column(name = "send_method")
	private String sendMethod;
	
	@Column(name = "sap_file_number")
	private String sapFileNumber;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contract_id",nullable=false)
    private Contract contract;
	
	@Column(name = "manual")
	private String isManual;
	
	@OneToMany(mappedBy="invoiceLine",fetch=FetchType.LAZY)
	private Set<InvoiceLineItems> invoiceLineItems;
	
	@OneToMany(mappedBy="invoiceImport",fetch=FetchType.LAZY)
	
	private Set<EbulkImport> ebulkImportItems;
		

	
	


	public Set<InvoiceLineItems> getInvoiceLineItems() {
		return invoiceLineItems;
	}


	public void setInvoiceLineItems(Set<InvoiceLineItems> invoiceLineItems) {
		this.invoiceLineItems = invoiceLineItems;
	}


	public Set<EbulkImport> getEbulkImportItems() {
		return ebulkImportItems;
	}


	public void setEbulkImportItems(Set<EbulkImport> ebulkImportItems) {
		this.ebulkImportItems = ebulkImportItems;
	}


	public String getIsManual() {
		return isManual;
	}


	public Invoice() {
		
	}
	
	
	public Contract getContract() {
		return contract;
	}


	public void setContract(Contract contract) {
		this.contract = contract;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	
	public Integer getInvoiceStatusValue() {
		return invoiceStatusValue;
	}

	public void setInvoiceStatusValue(Integer invoiceStatusValue) {
		this.invoiceStatusValue = invoiceStatusValue;
		
	}

	


	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	
	

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getCancelsInvoice() {
		return cancelsInvoice;
	}

	public void setCancelsInvoice(Integer cancelsInvoice) {
		this.cancelsInvoice = cancelsInvoice;
	}

	public Integer getAuthorisedBy() {
		return authorisedBy;
	}

	public void setAuthorisedBy(Integer authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	public Date getAuthorisedOn() {
		return authorisedOn;
	}

	public void setAuthorisedOn(Date authorisedOn) {
		this.authorisedOn = authorisedOn;
	}

	public Integer getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(Integer cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	public Date getCancelledOn() {
		return cancelledOn;
	}

	public void setCancelledOn(Date cancelledOn) {
		this.cancelledOn = cancelledOn;
	}

	public Integer getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(Integer paidStatus) {
		this.paidStatus = paidStatus;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public Integer getSentStatus() {
		return sentStatus;
	}

	public void setSentStatus(Integer sentStatus) {
		this.sentStatus = sentStatus;
	}

	public BigDecimal getNet() {
		return net;
	}

	public void setNet(BigDecimal net) {
		this.net = net;
	}

	public BigDecimal getGross() {
		return gross;
	}

	public void setGross(BigDecimal gross) {
		this.gross = gross;
	}

	public BigDecimal getVat() {
		return vat;
	}

	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvoiceFile() {
		return invoiceFile;
	}

	public void setInvoiceFile(String invoiceFile) {
		this.invoiceFile = invoiceFile;
	}

	public String getBackingFile() {
		return backingFile;
	}

	public void setBackingFile(String backingFile) {
		this.backingFile = backingFile;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceBuilding() {
		return sourceBuilding;
	}

	public void setSourceBuilding(String sourceBuilding) {
		this.sourceBuilding = sourceBuilding;
	}

	public String getSourceStreet() {
		return sourceStreet;
	}

	public void setSourceStreet(String sourceStreet) {
		this.sourceStreet = sourceStreet;
	}

	public String getSourceTown() {
		return sourceTown;
	}

	public void setSourceTown(String sourceTown) {
		this.sourceTown = sourceTown;
	}

	public String getSourceCounty() {
		return sourceCounty;
	}

	public void setSourceCounty(String sourceCounty) {
		this.sourceCounty = sourceCounty;
	}

	public String getSourcePostcode() {
		return sourcePostcode;
	}

	public void setSourcePostcode(String sourcePostcode) {
		this.sourcePostcode = sourcePostcode;
	}

	public String getSourceCountry() {
		return sourceCountry;
	}

	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}

	public String getSourceEmail() {
		return sourceEmail;
	}

	public void setSourceEmail(String sourceEmail) {
		this.sourceEmail = sourceEmail;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetBuilding() {
		return targetBuilding;
	}

	public void setTargetBuilding(String targetBuilding) {
		this.targetBuilding = targetBuilding;
	}

	public String getTargetStreet() {
		return targetStreet;
	}

	public void setTargetStreet(String targetStreet) {
		this.targetStreet = targetStreet;
	}

	public String getTargetTown() {
		return targetTown;
	}

	public void setTargetTown(String targetTown) {
		this.targetTown = targetTown;
	}

	public String getTargetCounty() {
		return targetCounty;
	}

	public void setTargetCounty(String targetCounty) {
		this.targetCounty = targetCounty;
	}

	public String getTargetPostcode() {
		return targetPostcode;
	}

	public void setTargetPostcode(String targetPostcode) {
		this.targetPostcode = targetPostcode;
	}

	public String getTargetCountry() {
		return targetCountry;
	}

	public void setTargetCountry(String targetCountry) {
		this.targetCountry = targetCountry;
	}

	public String getTargetEmail() {
		return targetEmail;
	}

	public void setTargetEmail(String targetEmail) {
		this.targetEmail = targetEmail;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCostCode() {
		return costCode;
	}

	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}

	public Integer getOdStatus() {
		return odStatus;
	}

	public void setOdStatus(Integer odStatus) {
		this.odStatus = odStatus;
	}

	public String getOdTimestamp() {
		return odTimestamp;
	}

	public void setOdTimestamp(String odTimestamp) {
		this.odTimestamp = odTimestamp;
	}

	public Date getOdCreatedon() {
		return odCreatedon;
	}

	public void setOdCreatedon(Date odCreatedon) {
		this.odCreatedon = odCreatedon;
	}

	public Integer getOdCreatedby() {
		return odCreatedby;
	}

	public void setOdCreatedby(Integer odCreatedby) {
		this.odCreatedby = odCreatedby;
	}

	public Date getOdUpdatedon() {
		return odUpdatedon;
	}

	public void setOdUpdatedon(Date odUpdatedon) {
		this.odUpdatedon = odUpdatedon;
	}

	public Integer getOdUpdatedby() {
		return odUpdatedby;
	}

	public void setOdUpdatedby(Integer odUpdatedby) {
		this.odUpdatedby = odUpdatedby;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getSendMethod() {
		return sendMethod;
	}

	public void setSendMethod(String sendMethod) {
		this.sendMethod = sendMethod;
	}

	public String getSapFileNumber() {
		return sapFileNumber;
	}

	public void setSapFileNumber(String sapFileNumber) {
		this.sapFileNumber = sapFileNumber;
	}


	public String gettIsManual() {
		return isManual;
	}


	public void setIsManual(String isManual) {
		this.isManual = isManual;
	}

	

	
	
	
}
