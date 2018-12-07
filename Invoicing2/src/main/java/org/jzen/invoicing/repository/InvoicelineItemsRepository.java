package org.jzen.invoicing.repository;

import org.jzen.invoicing.entity.InvoiceLineItems;
import org.jzen.invoicing.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicelineItemsRepository  extends JpaRepository<InvoiceLineItems,Long>{
	
	

}
