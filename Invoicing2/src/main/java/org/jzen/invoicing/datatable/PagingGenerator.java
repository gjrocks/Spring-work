package org.jzen.invoicing.datatable;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * utility class calculates the paging information
 */
public class PagingGenerator {

	private static final Logger logger = LoggerFactory.getLogger(PagingGenerator.class);

    private static final PagingGenerator pagingGenerator = new PagingGenerator();
    
    public static PagingGenerator getInstance() {
        return pagingGenerator;
    }
    
    private PagingGenerator() {
    }    
    
    public void generatePages(PagingData pagingBean) {
        final List pages = new ArrayList();
        final int totalNoPages = getTotalNoPages(pagingBean.getTotalNumResults(), pagingBean.getNumResultsPerPage());
        final int pageNo = pagingBean.getPageNo();
        
        int startIndex = 0;
        // this sets the pages used for previous and next of current page
        if (pageNo <= 2) { 
            startIndex = 1;
        } else {
            if (totalNoPages - pageNo < 2) startIndex = totalNoPages - 4;
            else startIndex = pageNo - 2;
        }
        
        for (int i = startIndex; i < startIndex + pagingBean.getNumOfPagesToDisplay(); i++) {
             if (i <= totalNoPages && i > 0) {
                pages.add(i);
             } else if (i > totalNoPages) {
                break;
             }
        }
        
        pagingBean.setTotalNumPages(totalNoPages);
        pagingBean.setPages(pages);
        
    }
    
    private int getTotalNoPages(int totalNoResults, int noItemsPerPage) {
        int totalNoPages = 1;
        int pageCalc = totalNoResults/noItemsPerPage;
        //logger.debug("pageCalc="+pageCalc);
        
        if ((totalNoResults % noItemsPerPage) == 0) {
            totalNoPages = pageCalc;
        } else {
            totalNoPages = pageCalc + 1;
        }
        
        return totalNoPages;
        
    }    
        
    
    
}
