
package org.jzen.invoicing.datatable;


import org.jzen.invoicing.controller.CurrentInvociesController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Used to control the paging information and sql used by the CommonDataService
 */
public class PagingConfig {

	private static final Logger logger = LoggerFactory.getLogger(PagingConfig.class);
    
    private String  countSql;
    private String  fetchSql;
    
    private final int     maxResultsPerPage   = 100;
    private final int     minResultsPerPage   = 5;
    
    private int     numResultsPerPage   = 10;
    private int     pageNo              = 1;

    public PagingConfig(String config) {
        parseConfig(config);
    }


    private void parseConfig(String config) {
        
        if (logger.isDebugEnabled()) {
            logger.debug("parseConfig: " + config);                    
        }

        final String[] values = config.split("[|]");
        
        if (values.length < 1) {
            throw new IllegalArgumentException("Missing config for pagingSQL");
        }
        
        this.countSql = values[0];
        
        if (values.length >= 2) {
            this.fetchSql = values[1];
        }
        
    
        if (values.length >= 3) {
            this.numResultsPerPage = Integer.parseInt(values[3]);
        }
      
    }

 
    
    public int getNumResultsPerPage() {
        return numResultsPerPage;
    }

    public int getPageNo() {
        return pageNo;
    }
    


    public void setPageNo(int startPageNo) {
        if (startPageNo > 0) {
            this.pageNo = startPageNo;
        }
    }
    

    public String getCountSql() {
        return countSql;
    }

    public String getFetchSql() {
        return fetchSql;
    }

    public void setNumResultsPerPage(int numResultsPerPage) {
        if (numResultsPerPage > minResultsPerPage && numResultsPerPage <= maxResultsPerPage) {
            this.numResultsPerPage = numResultsPerPage;
        }
    }
}
