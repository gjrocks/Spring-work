package org.jzen.invoicing.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.repository.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;


public class CurrentInvoicesSpecificationBuilder {
	
	private final List<SearchCriteria> params;
	 
    public CurrentInvoicesSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public CurrentInvoicesSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
    
    public Specification<Invoice> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<Invoice>> specs = new ArrayList<Specification<Invoice>>();
        for (SearchCriteria param : params) {
            specs.add(new CurrentInvoicesSpecification(param));
        }
 
        Specification<Invoice> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
     //       result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }

}
