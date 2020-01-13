package org.jzen.jdf.lux.tracking.repository;

import org.jzen.jdf.lux.tracking.entity.ProposalTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalTrackRepository extends JpaRepository<ProposalTrack, Integer>,JpaSpecificationExecutor<ProposalTrack>,PagingAndSortingRepository<ProposalTrack, Integer> {

    ProposalTrack findByAgreementNumber(String agreementNumber);

    @Modifying
    @Query("update ProposalTrack pr set pr.assignedTo = :assignedTo where pr.agreementNumber = :agreementNumber")
    int setAgreementNumberAssignedTo(@Param("assignedTo") String  assignedTo, @Param("agreementNumber") String agreementNumber);
}
/*
@Repository
public interface CurrentInvoicesRepository extends JpaRepository<Invoice,Long>,JpaSpecificationExecutor<Invoice>,PagingAndSortingRepository<Invoice, Long>{
	
	 @Query("select invoice from Invoice invoice left join fetch invoice.invoiceLineItems left join fetch invoice.contract  where invoice.invoiceNum =:invoiceNum")
	public Invoice getInvoiceByInvoiceNum(@Param("invoiceNum")String invoiceNum);
	
	
	
	@Query("select invoice from Invoice invoice left join fetch invoice.invoiceLineItems left join fetch invoice.contract left join fetch invoice.ebulkImportItems  where invoice.invoiceNum in (:invoiceNumList)")
	public List<Invoice> getInvoicesByInvoiceNumList(@Param("invoiceNumList")List<String> invoiceNumList);
	


 */