package org.jzen.invoicing.bean;

import java.math.BigDecimal;

public class InvoiceLineItemsBean {
	
	private Integer invoiceId;
	private String invoiceName;
	private String urn;
	private BigDecimal itemNet;
	private BigDecimal itemVat;
	private BigDecimal itemGross;
	private Integer quantity;
	private BigDecimal totalNet;
	private BigDecimal totalVat;
	private BigDecimal totalGross;
	private String productId;
	private String productName;
	
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceName() {
		return invoiceName;
	}
	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}
	public String getUrn() {
		return urn;
	}
	public void setUrn(String urn) {
		this.urn = urn;
	}
	public BigDecimal getItemNet() {
		return itemNet;
	}
	public void setItemNet(BigDecimal itemNet) {
		this.itemNet = itemNet;
	}
	public BigDecimal getItemVat() {
		return itemVat;
	}
	public void setItemVat(BigDecimal itemVat) {
		this.itemVat = itemVat;
	}
	public BigDecimal getItemGross() {
		return itemGross;
	}
	public void setItemGross(BigDecimal itemGross) {
		this.itemGross = itemGross;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	

}
