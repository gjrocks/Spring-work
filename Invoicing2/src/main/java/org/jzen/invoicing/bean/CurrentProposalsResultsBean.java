package org.jzen.invoicing.bean;

import java.util.Date;

import javax.persistence.PreUpdate;

public class CurrentProposalsResultsBean {
	


   
    private Integer id;

  
    private String countryCode;

  
    private String agreementNumber;

    
    String quoteNumber;

  
    Integer alfaCaseId;

   
    String alfaCaseStatus;

    
    private Integer statusId;

    private String trackingStatus;
   
    private String icsId;

    Date updatedAt;

  
    String updatedBy;

   
    public String getTrackingStatus() {
		return trackingStatus;
	}

	public void setTrackingStatus(String trackingStatus) {
		this.trackingStatus = trackingStatus;
	}

	Date createdAt;

   
    String createdBy;
    
    String assignedTo;
    
    Date assignedDate;
    
   
    String errorText;
  //following can be deleted
    
    private String invoiceNum;
	private String clientName;
	private String contractName;
	private String invoiceDate;
	private String paymentMethod;
	private String sendMethod;
	private String sentDate;
	private String sap;
	private String invoiceStatus;
	
	
	

    public String getErrorText() {
		return errorText;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

  

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getIcsId() {
        return icsId;
    }

    public void setIcsId(String icsId) {
        this.icsId = icsId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(String quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public Integer getAlfaCaseId() {
        return alfaCaseId;
    }

    public void setAlfaCaseId(Integer alfaCaseId) {
        this.alfaCaseId = alfaCaseId;
    }

    public String getAlfaCaseStatus() {
        return alfaCaseStatus;
    }

    public void setAlfaCaseStatus(String alfaCaseStatus) {
        this.alfaCaseStatus = alfaCaseStatus;
    }

	public void setErrorText(String errorText) {
		this.errorText=errorText;
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

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	//following can be deleted
	
	

}
