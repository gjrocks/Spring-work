package org.jzen.jdf.lux.domain;

import java.io.Serializable;
import java.util.Set;

import org.jzen.jdf.lux.tracking.entity.ProposalThirdParty;

public class TrackingStatusMessage implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6892788067237811432L;
    private String agreementNumber;
    private Integer statusCode;
    private String type;
    private Set<ProposalThirdParty> thirdParties;
    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public Set<ProposalThirdParty> getThirdParties() {
		return thirdParties;
	}

	public void setThirdParties(Set<ProposalThirdParty> thirdParties) {
		this.thirdParties = thirdParties;
	}


}
