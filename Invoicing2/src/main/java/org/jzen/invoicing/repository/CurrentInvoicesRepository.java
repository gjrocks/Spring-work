package org.jzen.invoicing.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentInvoicesRepository extends JpaRepository<Invoice,Long>,JpaSpecificationExecutor<Invoice>,PagingAndSortingRepository<Invoice, Long>{
	
	 @Query("select invoice from Invoice invoice left join fetch invoice.invoiceLineItems left join fetch invoice.contract  where invoice.invoiceNum =:invoiceNum")
	public Invoice getInvoiceByInvoiceNum(@Param("invoiceNum")String invoiceNum);
	
	
	
	@Query("select invoice from Invoice invoice left join fetch invoice.invoiceLineItems left join fetch invoice.contract left join fetch invoice.ebulkImportItems  where invoice.invoiceNum in (:invoiceNumList)")
	public List<Invoice> getInvoicesByInvoiceNumList(@Param("invoiceNumList")List<String> invoiceNumList);
	


}
