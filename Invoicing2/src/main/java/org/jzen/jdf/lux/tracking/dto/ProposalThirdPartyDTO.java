package org.jzen.jdf.lux.tracking.dto;

/**
 * @author Created by rd61665 on 27/May/2019
 */

public class ProposalThirdPartyDTO {

    String alfaThirdPartyNumber;
    String thirdPartyRole;

    public String getAlfaThirdPartyNumber() {
        return alfaThirdPartyNumber;
    }

    public void setAlfaThirdPartyNumber(String alfaThirdPartyNumber) {
        this.alfaThirdPartyNumber = alfaThirdPartyNumber;
    }

    public String getThirdPartyRole() {
        return thirdPartyRole;
    }

    public void setThirdPartyRole(String thirdPartyRole) {
        this.thirdPartyRole = thirdPartyRole;
    }

    public ProposalThirdPartyDTO(String alfaThirdPartyNumber, String thirdPartyRole) {
        super();
        this.alfaThirdPartyNumber = alfaThirdPartyNumber;
        this.thirdPartyRole = thirdPartyRole;
    }

    @Override
    public String toString() {
        return "ProposalThirdPartyDTO [alfaThirdPartyNumber = " + alfaThirdPartyNumber + ", thirdPartyRole = " + thirdPartyRole + "]";
    }
}