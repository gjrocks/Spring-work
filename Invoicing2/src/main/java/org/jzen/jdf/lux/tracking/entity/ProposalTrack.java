package org.jzen.jdf.lux.tracking.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "JDF_ALFA_PROP_TRACKING")
public class ProposalTrack implements Serializable {

    @Id
    @Column(name = "JDF_ALFA_PROP_TRACKING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CTRY_CD")
    private String countryCode;

    @Column(name = "ALFA_AGRMNT_NUM")
    private String agreementNumber;

    @Column(name = "ALFA_QUOTE_NUM")
    String quoteNumber;

    @Column(name = "ALFA_CASE_ID")
    Integer alfaCaseId;

    @Column(name = "ALFA_CASE_ST")
    String alfaCaseStatus;

    @Column(name = "STATUS_ID")
    private Integer statusId;

    @Column(name = "PROP_ICS_ID")
    private String icsId;

    @Column(name = "UPDATED_DT")
    @LastModifiedDate
    Date updatedAt;

    @Column(name = "UPDATED_BY")
    String updatedBy;  

    @Column(name = "CREATED_DT")
    @CreatedDate
    Date createdAt;

    @Column(name = "CREATED_BY")
    String createdBy;

    @Column(name="ERROR_TEXT")
    String errorText;
    
    @Column(name="ASSIGN_TO")
    String assignedTo;
    
    
   
    
    
    public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@OneToMany(mappedBy = "proposalTrack", fetch = FetchType.EAGER)
    private Set<ProposalThirdParty> proposalTPIds;

    public ProposalTrack(String countryCd, String agreementNum, Integer statusId) {
        this.countryCode = countryCd;
        this.agreementNumber = agreementNum;
        this.statusId = statusId;
    }

    public ProposalTrack() {
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

    public Set<ProposalThirdParty> getProposalTPIds() {
        return proposalTPIds;
    }

    public void setProposalTPIds(Set<ProposalThirdParty> proposalTPIds) {
        this.proposalTPIds = proposalTPIds;
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

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}

