package org.jzen.invoicing.repository;

import java.util.Date;
import java.util.List;

import org.jzen.invoicing.entity.InvoiceRunDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRunRepository extends JpaRepository<InvoiceRunDates,Long> {
	
	 @Query("select invoiceRunDates from InvoiceRunDates invoiceRunDates where invoiceRunDates.invoicePeriodEndDate =("
	 		+ "SELECT min(invDates.invoicePeriodEndDate) FROM InvoiceRunDates invDates WHERE invDates.runStatus = 0)")
	 		 InvoiceRunDates getCurrentRunDates();
	 
	 @Query("select invoiceRunDates from InvoiceRunDates invoiceRunDates where invoiceRunDates.runStatus = 0 and invoiceRunDates.id not in ("+
			 "select invoiceRunDatesinner.id from InvoiceRunDates invoiceRunDatesinner where invoiceRunDatesinner.invoicePeriodEndDate =("
		 		+ "SELECT min(invDates.invoicePeriodEndDate) FROM InvoiceRunDates invDates WHERE invDates.runStatus = 0))"
		 		+ " order by invoiceRunDates.invoicePeriodStartDate asc")
	 List<InvoiceRunDates> getAllPendingNextRunDates();
	 
	 @Query("select invoiceRunDates from InvoiceRunDates invoiceRunDates where invoiceRunDates.invoicePeriodEndDate =:prevEndDate")
	 InvoiceRunDates getInvoiceRunDatesByInvoicePeriodEndDate(@Param("prevEndDate")Date prevEndDate);
	 
	 @Query("select invoiceRunDates from InvoiceRunDates invoiceRunDates where invoiceRunDates.invoicePeriodStartDate =:prevStartDate")
	 InvoiceRunDates getInvoiceRunDatesByInvoicePeriodStartDate(@Param("prevStartDate")Date prevStartDate);
	 
	 @Modifying
	 @Query("update InvoiceRunDates invoiceRunDates set invoiceRunDates.invoicePeriodEndDate = :newEndDate where invoiceRunDates.id = :id")
	 void updateInvoiceRunEndDate(@Param("newEndDate")Date newEndDate,@Param("id")Long id);
	 
	
	 @Modifying
	 @Query("update InvoiceRunDates invoiceRunDates set invoiceRunDates.invoicePeriodStartDate = :newStartDate where invoiceRunDates.id = :id")
	 void updateInvoiceRunStartDate(@Param("newStartDate")Date newStartDate,@Param("id")Long id);
	 
}
