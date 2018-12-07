package org.jzen.invoicing.repository;

import java.util.Date;
import java.util.List;

import org.jzen.invoicing.entity.EbulkImport;
import org.jzen.invoicing.entity.InvoiceRunDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface EbulkImportRepository extends JpaRepository<EbulkImport,Long>{

//	@Query("select ebulkImport from EbulkImport ebulkImport where  ebulkImport.invoiceNum in( :invoiceNumList)")	
//	List<EbulkImport> getEbulkImportListByInvoiceNum(@Param("invoiceNumList")List<String> invoiceNum);
//	
	
}
