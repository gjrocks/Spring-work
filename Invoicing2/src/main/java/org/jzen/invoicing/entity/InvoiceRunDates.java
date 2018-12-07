package org.jzen.invoicing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice_run_dates")
public class InvoiceRunDates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Long id;
	
	@Column(name="period_start_date")
	private Date invoicePeriodStartDate;
	
	@Column(name="period_end_date")
	private Date invoicePeriodEndDate;
	
	@Column(name="run_status")
	private boolean runStatus;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInvoicePeriodStartDate() {
		return invoicePeriodStartDate;
	}

	public void setInvoicePeriodStartDate(Date invoicePeriodStartDate) {
		this.invoicePeriodStartDate = invoicePeriodStartDate;
	}

	public Date getInvoicePeriodEndDate() {
		return invoicePeriodEndDate;
	}

	public void setInvoicePeriodEndDate(Date invoicePeriodEndDate) {
		this.invoicePeriodEndDate = invoicePeriodEndDate;
	}

	public boolean isRunStatus() {
		return runStatus;
	}

	public void setRunStatus(boolean runStatus) {
		this.runStatus = runStatus;
	}

	

}
