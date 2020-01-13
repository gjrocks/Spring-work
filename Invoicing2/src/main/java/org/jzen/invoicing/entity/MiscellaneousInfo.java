package org.jzen.invoicing.entity;

/**
 * Class containing all additional parameters required to be stored into Third Party table in tracking database.
 * @author ss49677
 */
public class MiscellaneousInfo {

    String sapId;

    public MiscellaneousInfo(String sapId) {
        this.sapId = sapId;
    }

    public MiscellaneousInfo() {
    }

    public String getSapId() {
        return sapId;
    }

    public void setSapId(String sapId) {
        this.sapId = sapId;
    }
}
