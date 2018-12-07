package org.jzen.invoicing.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_billing_record")
public class BillingRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "urn", nullable = false)  
	private Integer billingRecordUrn;
	
	@Column(name = "client_id")
	private String clientId;
	
	@Column(name = "contract_id")
	private String contractId;
	
	@Column(name = "category_id")
	private String categoryId;
	
	@Column(name = "candidate_id")
	private String candidateId;
	
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "candidate_product_id")
	private String candidatProductId;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "contract_name")
	private String contracName;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "candidate_name")
	private String candidateName;
	
	@Column(name = "candidate_fname")
	private String candidateFirstName;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "addition")
	private Integer addition;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "standard_price")
	private BigDecimal standardPrice;
	
	@Column(name = "standard_cost")
	private BigDecimal standardCost;
	
	@Column(name = "nominal_code")
	private String nominalCode;
	
	@Column(name = "client_code")
	private String clientCode;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "invoice_status")
	private Integer invoiceStatus;
	 
	@Column(name = "invoice_id")
	private long invoiceId;
	
	@Column(name = "billing_date")
	private Date billingDate;
	
	@Column(name = "extract_date")
	private Date extractDate;
	
	@Column(name = "od_status")
	private Integer odStatus;

	@Column(name = "od_timestamp")
	private Date odTimeStamp;

	@Column(name = "od_createdon")
	private Date odCreatedOn;

	@Column(name = "od_createdby")
	private Long odCreatedBy;

	@Column(name = "od_updatedon")
	private Date odUpdatedOn;

	@Column(name = "od_updatedby")
	private Long odUpdatedBy;

	public Integer getBillingRecordUrn() {
		return billingRecordUrn;
	}

	public void setBillingRecordUrn(Integer billingRecordUrn) {
		this.billingRecordUrn = billingRecordUrn;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCandidatProductId() {
		return candidatProductId;
	}

	public void setCandidatProductId(String candidatProductId) {
		this.candidatProductId = candidatProductId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getContracName() {
		return contracName;
	}

	public void setContracName(String contracName) {
		this.contracName = contracName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateFirstName() {
		return candidateFirstName;
	}

	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getAddition() {
		return addition;
	}

	public void setAddition(Integer addition) {
		this.addition = addition;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	public BigDecimal getStandardCost() {
		return standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	public String getNominalCode() {
		return nominalCode;
	}

	public void setNominalCode(String nominalCode) {
		this.nominalCode = nominalCode;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public Date getExtractDate() {
		return extractDate;
	}

	public void setExtractDate(Date extractDate) {
		this.extractDate = extractDate;
	}

	public Integer getOdStatus() {
		return odStatus;
	}

	public void setOdStatus(Integer odStatus) {
		this.odStatus = odStatus;
	}

	public Date getOdTimeStamp() {
		return odTimeStamp;
	}

	public void setOdTimeStamp(Date odTimeStamp) {
		this.odTimeStamp = odTimeStamp;
	}

	public Date getOdCreatedOn() {
		return odCreatedOn;
	}

	public void setOdCreatedOn(Date odCreatedOn) {
		this.odCreatedOn = odCreatedOn;
	}

	public Long getOdCreatedBy() {
		return odCreatedBy;
	}

	public void setOdCreatedBy(Long odCreatedBy) {
		this.odCreatedBy = odCreatedBy;
	}

	public Date getOdUpdatedOn() {
		return odUpdatedOn;
	}

	public void setOdUpdatedOn(Date odUpdatedOn) {
		this.odUpdatedOn = odUpdatedOn;
	}

	public Long getOdUpdatedBy() {
		return odUpdatedBy;
	}

	public void setOdUpdatedBy(Long odUpdatedBy) {
		this.odUpdatedBy = odUpdatedBy;
	}
	
	
	

}
