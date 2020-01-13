package org.jzen.jdf.lux.tracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "JDF_ALFA_PROP_TP")
public class ProposalThirdParty implements Serializable {

    @Id
    @Column(name = "JDF_ALFA_PROP_TP_ID")
    private Integer id;

    @Column(name="TP_ROLE")
    private String thirdPartyRole;

    @Column(name="JDF_ALFA_PROP_TRACKING_ID")
    private Integer proposalTrackingId;

    @Column(name = "JDF_ALFA_TP_TRACKING_ID")
    private Integer thirdPartyTrackingId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="JDF_ALFA_PROP_TRACKING_ID", insertable = false, updatable = false)
    private ProposalTrack proposalTrack;

//    @JsonIgnore
    @OneToOne
    @JoinColumn(name="JDF_ALFA_TP_TRACKING_ID", insertable = false, updatable = false)
    private ThirdPartyTrack thirdPartyTrack;

    public ProposalThirdParty() {
    }

    public ProposalTrack getProposalTrack() {
        return proposalTrack;
    }

    public void setProposalTrack(ProposalTrack proposalTrack) {
        this.proposalTrack = proposalTrack;
    }

    public ThirdPartyTrack getThirdPartyTrack() {
        return thirdPartyTrack;
    }

    public void setThirdPartyTrack(ThirdPartyTrack thirdPartyTrack) {
        this.thirdPartyTrack = thirdPartyTrack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThirdPartyRole() {
        return thirdPartyRole;
    }

    public void setThirdPartyRole(String thirdPartyRole) {
        this.thirdPartyRole = thirdPartyRole;
    }

    public Integer getProposalTrackingId() {
        return proposalTrackingId;
    }

    public void setProposalTrackingId(Integer proposalTrackingId) {
        this.proposalTrackingId = proposalTrackingId;
    }

    public Integer getThirdPartyTrackingId() {
        return thirdPartyTrackingId;
    }

    public void setThirdPartyTrackingId(Integer thirdPartyTrackingId) {
        this.thirdPartyTrackingId = thirdPartyTrackingId;
    }
}