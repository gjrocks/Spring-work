package org.jzen.jdf.lux.tracking.dao;

/**
 * The enum will be in sync with the status codes saved in database.
 * @author ss49677
 */
public enum TrackingStatus {
    INIT            (1),        //Third party initialized
    PROP_TP_INIT    (2),        //Proposal's third parties are initialized
    READY           (3),        //Proposal is ready for load
    TP_ERR          (4),        //Error in saving proposal's third parties
    NBL_SUCC        (5),        //Data saved in NBL Successfully
    NBL_ERR         (6),        //Error saving to NBL
    ICS_SUCC        (7),        //Data saved in ICS Successfully
    ICS_ERR         (8),        //Error saving to ICS
    SUCCESS         (9),        //Third Party/ Proposal saved successfully in ICS and Alfa
    ALFA_ERR        (10),       //Error saving to Alfa
    RESUBMIT        (11),       //Resubmitting third party or proposal
    API_ERR        (100),       //Error in API Gateway
    APP_ERR        (101),       //Error in application code.
    COUNTRY_UNSUPPORTED(102);   //Country not supported in application

    int status;

    TrackingStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
}
