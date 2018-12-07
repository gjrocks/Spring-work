package org.jzen.invoicing.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.repository.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

public class CurrentInvoicesSpecification implements Specification<Invoice> {
	
	 private SearchCriteria criteria;
	 public CurrentInvoicesSpecification(final SearchCriteria criteria) {
			super();
			this.criteria = criteria;
		}

		public SearchCriteria getCriteria() {
			return criteria;
		}
	 
	    @Override
	    public Predicate toPredicate
	      (Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	  
	        if (criteria.getOperation().equalsIgnoreCase(">")) {
	            return builder.greaterThanOrEqualTo(
	              root.<String> get(criteria.getKey()), criteria.getValue().toString());
	        } 
	        else if (criteria.getOperation().equalsIgnoreCase("<")) {
	            return builder.lessThanOrEqualTo(
	              root.<String> get(criteria.getKey()), criteria.getValue().toString());
	        } 
	        else if (criteria.getOperation().equalsIgnoreCase(":")) {
	            if (root.get(criteria.getKey()).getJavaType() == String.class) {
	                return builder.like(
	                  root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
	            } else {
	                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
	            }
	        }
	        return null;
	    }

}
