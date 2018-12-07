
package org.jzen.invoicing.datatable;

import java.util.List;

/**
 * The output data from the CommonDataService
 */
public class PagingData {

    public static final String NAME = "pagingBean";

    // this controls the amount of pageNo's shown in the paging bar
    private int     numOfPagesToDisplay = 5;
    
    private int     numResultsPerPage   = 10;
    private int     pageNo              = 1;
    
    // the page numbers as a list 
    private List<Integer>   pages;
    
    // the results list
    private List            results;
    // calculations for this result list
    private int             totalNumPages;
    private int             totalNumResults;    
    
    public PagingData(int pageNo) {
        this.pageNo = pageNo;
    }
    
    public boolean getShowStart() {
        return getPageNo() != 1;
    }

    public boolean getShowEnd() {
        return getPageNo() != totalNumPages;
    }    
    
    public boolean getIsNext() {
        return getPageNo() < totalNumPages;
    }

    public boolean getIsPrevious() {
        return getPageNo() > 1;
    }

    public int getPageNo() {
        return pageNo;
    }


    public List<Integer> getPages() {
        return this.pages;
    }

    public List getResults() {
        return this.results;
    }

    public int getTotalNumPages() {
        return this.totalNumPages;
    }

    public int getTotalNumResults() {
        return this.totalNumResults;
    }


    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }


    public void setResults(List results) {
        this.results = results;
    }

    public void setTotalNumPages(int totalNoPages) {
        this.totalNumPages = totalNoPages;
    }

    public void setTotalNumResults(int totalNoResults) {
        this.totalNumResults = totalNoResults;
    }

    public int getStart() {
        int start = 1 + ((pageNo-1)*numResultsPerPage);
        return start;
    }
    
    public int getEnd() {
        int resultsSize = (results!=null?results.size():0);
        int end = resultsSize + ((pageNo-1)*numResultsPerPage);
        return end;
    }

    public String getShowingResults() {
        int start = getStart();
        int end = getEnd();
        
        int resultsSize = (results!=null?results.size():0);
        if (resultsSize == 0) {
            return "Showing 0 results";
        } else if (totalNumPages == 1) {            
            return "Showing "+resultsSize+" result"+ (resultsSize>1?"s":"");
        } else if (start == end && totalNumPages == getPageNo()) {
            return "Showing last "+" of "+getTotalNumResults()+" results";
        } else{
            return "Showing "+getStart()+" - "+getEnd()+" of "+getTotalNumResults()+" results";
        }
    }

    public String toString() {
        String toString = "\nresults: " + this.results;        
        toString += "\npages: " + this.pages;
        toString += "\ntotalNoPages: " + this.totalNumPages;
        toString += "\ntotalNoResults: " + this.totalNumResults;
        
        return toString;
    }

    public int getNumOfPagesToDisplay() {
        return numOfPagesToDisplay;
    }

    public void setNumResultsPerPage(int numResultsPerPage) {
        this.numResultsPerPage = numResultsPerPage;
    }

    public int getNumResultsPerPage() {
        return numResultsPerPage;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    
    public int getOffSet() {
        return pageNo - 1;
    }
    
}
