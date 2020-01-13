package org.jzen.jdf.lux.tracking.entity;

import javax.persistence.*;

import static org.jzen.jdf.lux.application.utility.ConstantIdentifiers.APP_ID;

import java.util.Date;

/**
 * @author Created by Sayali Shenolikar (ss49677) on 31/01/2019
 * Entity class corresponding to JDF_ALFA_PROP_TRACKING_HISTORY table of Tracking DB
 */

@Entity
@Table(name = "JDF_ALFA_PROP_TRACKING_HISTORY")
public class ProposalTrackHistory {

    @Id
    @Column(name = "JDF_ALFA_PROP_TRACKING_HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "JDF_ALFA_PROP_TRACKING_ID")
    Integer trackingId;

    @Column(name = "ALFA_QUOTE_NUM")
    String quoteNumber;

    @Column(name = "ALFA_CASE_ID")
    Integer alfaCaseId;

    @Column(name = "ALFA_CASE_ST")
    String alfaCaseStatus;

    @Column(name = "OLD_STATUS_ID")
    Integer oldStatus;

    @Column(name = "NEW_STATUS_ID")
    Integer newStatus;

    @Column(name = "ERR_MSG", columnDefinition="blob")
    String errorMessage;

    @Column(name = "UPDATED_DT")
    Date updatedAt;

    @Column(name = "UPDATED_BY")
    String updatedBy;

    @Column(name = "CREATED_DT")
    Date createdAt;

    @Column(name = "CREATED_BY")
    String createdBy;

    public ProposalTrackHistory(Integer trackingId, Integer oldStatus, Integer newStatus, String errorMessage) {
        this.trackingId = trackingId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.errorMessage = errorMessage;
        this.createdAt = new Date();
        this.createdBy = APP_ID;
    }

    public ProposalTrackHistory(ProposalTrack proposalTrack, Integer newStatus, String errorMessage) {
        this.trackingId = proposalTrack.getId();
        this.quoteNumber = proposalTrack.getQuoteNumber();
        this.alfaCaseId = proposalTrack.getAlfaCaseId();
        this.alfaCaseStatus = proposalTrack.getAlfaCaseStatus();
        this.oldStatus = proposalTrack.getStatusId();
        this.newStatus = newStatus;
        this.errorMessage = errorMessage;
        this.createdAt = new Date();
        this.createdBy = APP_ID;
    }

    public ProposalTrackHistory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Integer trackingId) {
        this.trackingId = trackingId;
    }

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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
        this.updatedBy = APP_ID;
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
        this.createdBy = APP_ID;
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
}