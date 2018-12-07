package org.jzen.invoicing.repository;

import org.jzen.invoicing.entity.Contract;
import org.jzen.invoicing.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRespository extends JpaRepository<Contract,Long>,JpaSpecificationExecutor<Contract>,PagingAndSortingRepository<Contract, Long>{

}
