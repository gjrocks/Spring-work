package org.jzen.invoicing.entity;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "invoice_line_items")

public class InvoiceLineItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "urn", nullable = false)
	private Integer urnInvoiceLineItems;

	

	@Column(name = "name")
	private String lineItemName;

	@Column(name = "description")
	private String lineItemDesc;

	@Column(name = "net")
	private BigDecimal net;

	@Column(name = "vat")
	private BigDecimal vat;

	@Column(name = "gross")
	private BigDecimal gross;

	@Column(name = "total_net")
	private BigDecimal totalNet;

	@Column(name = "total_vat")
	private BigDecimal totalVat;

	@Column(name = "total_gross")
	private BigDecimal totalGross;

	@Column(name = "qty")
	private Integer quantity;

	@Column(name = "vat_rate")
	private BigDecimal vatRate;

	@Column(name = "comments")
	private String comments;

	@Column(name = "od_status")
	private Integer odStatus;

	@Column(name = "od_timestamp")
	private Date odTimeStamp;

	@Column(name = "od_createdon")
	private Date odCreatedOn;

	@Column(name = "od_createdby")
	private Integer odCreatedBy;

	@Column(name = "od_updatedon")
	private Date odUpdatedOn;

	@Column(name = "od_updatedby")
	private Integer odUpdatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id")
	private Invoice invoiceLine;
	

	public Integer getUrnInvoiceLineItems() {
		return urnInvoiceLineItems;
	}

	public void setUrnInvoiceLineItems(Integer urnInvoiceLineItems) {
		this.urnInvoiceLineItems = urnInvoiceLineItems;
	}

	

	public String getLineItemName() {
		return lineItemName;
	}

	public void setLineItemName(String lineItemName) {
		this.lineItemName = lineItemName;
	}

	public String getLineItemDesc() {
		return lineItemDesc;
	}

	public void setLineItemDesc(String lineItemDesc) {
		this.lineItemDesc = lineItemDesc;
	}

	public BigDecimal getNet() {
		return net;
	}

	public void setNet(BigDecimal net) {
		this.net = net;
	}

	public BigDecimal getVat() {
		return vat;
	}

	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}

	public BigDecimal getGross() {
		return gross;
	}

	public void setGross(BigDecimal gross) {
		this.gross = gross;
	}

	public BigDecimal getTotalNet() {
		return totalNet;
	}

	public void setTotalNet(BigDecimal totalNet) {
		this.totalNet = totalNet;
	}

	public BigDecimal getTotalVat() {
		return totalVat;
	}

	public void setTotalVat(BigDecimal totalVat) {
		this.totalVat = totalVat;
	}

	public BigDecimal getTotalGross() {
		return totalGross;
	}

	public void setTotalGross(BigDecimal totalGross) {
		this.totalGross = totalGross;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Integer getOdCreatedBy() {
		return odCreatedBy;
	}

	public void setOdCreatedBy(Integer odCreatedBy) {
		this.odCreatedBy = odCreatedBy;
	}

	public Date getOdUpdatedOn() {
		return odUpdatedOn;
	}

	public void setOdUpdatedOn(Date odUpdatedOn) {
		this.odUpdatedOn = odUpdatedOn;
	}

	public Integer getOdUpdatedBy() {
		return odUpdatedBy;
	}

	public void setOdUpdatedBy(Integer odUpdatedBy) {
		this.odUpdatedBy = odUpdatedBy;
	}

}
