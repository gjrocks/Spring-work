package org.jzen.jdf.lux.tracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

import org.jzen.jdf.lux.domain.MiscellaneousInfo;

import java.io.IOException;
import java.io.Serializable;

@Entity
@Table(name = "JDF_ALFA_TP_TRACKING")
public class ThirdPartyTrack implements Serializable {

    @Id
    @Column(name = "JDF_ALFA_TP_TRACKING_ID")
    private int id;

    @Column(name = "ICS_TP_ID")
    private String icsId;

    @Column(name="CTRY_CD")
    private String countryCode;
    
    @Column(name="ALFA_TP_TYPE")
    private String alfaTpType;
    
    @Column(name="ALFA_TP_NBR")
    private String alfaTpNumber;

    @Column(name="STATUS_ID")
    private Integer statusId;

    @JsonIgnore
    @Lob
    @Column(name = "MISC_INFO", columnDefinition = "text", length = 1000)
    String miscInfo;
    
    @JsonIgnore
    @OneToOne(mappedBy = "thirdPartyTrack", fetch = FetchType.EAGER)
    private ProposalThirdParty proposalThirdParty;

    public ThirdPartyTrack(String icsThirdPartyId) {
        this.icsId = icsThirdPartyId;
    }

    public ThirdPartyTrack() {
    }

    public String getIcsId() {
        return icsId;
    }

    public void setIcsId(String icsId) {
        this.icsId = icsId;
    }

    public ProposalThirdParty getProposalThirdParty() {
        return proposalThirdParty;
    }

    public void setProposalThirdParty(ProposalThirdParty proposalThirdParty) {
        this.proposalThirdParty = proposalThirdParty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAlfaTpType() {
		return alfaTpType;
	}

	public void setAlfaTpType(String alfaTpType) {
		this.alfaTpType = alfaTpType;
	}

	public String getAlfaTpNumber() {
		return alfaTpNumber;
	}

	public void setAlfaTpNumber(String alfaTpNumber) {
		this.alfaTpNumber = alfaTpNumber;
	}

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public MiscellaneousInfo getMiscInfo() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MiscellaneousInfo miscellaneousInfo = new MiscellaneousInfo();

        if(this.miscInfo != null){
            miscellaneousInfo = objectMapper.readValue(this.miscInfo, MiscellaneousInfo.class);
        }

        return miscellaneousInfo;
    }

    public void setMiscInfo(String miscInfo) {
        this.miscInfo = miscInfo;
    }
}
