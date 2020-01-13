package org.jzen.invoicing.repository.specification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.jzen.invoicing.bean.CurrentProposalsBean;
import org.jzen.jdf.lux.tracking.entity.ProposalTrack;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProposalSearchSpecificaton {
	
	
	
	public  Specification<ProposalTrack> findByCriteria(final CurrentProposalsBean filter) {
		return new Specification<ProposalTrack>() {
			
			@Override
			public Predicate toPredicate(Root<ProposalTrack> root, CriteriaQuery<?> query, CriteriaBuilder cb) {


							
				List<Predicate> predicates = new ArrayList<>();

				// If designation is specified in filter, add equal where clause
				if (!StringUtils.isEmpty(filter.getProposalNum())) {
					predicates.add(cb.like(cb.lower(root.get("agreementNumber")),
							"%" + filter.getProposalNum().trim().toLowerCase() + "%"));

				}
/*
				if (!StringUtils.isEmpty(filter.getInvoiceNumFromSearch())) {
					predicates
							.add(cb.greaterThanOrEqualTo(root.get("invoiceNum"), filter.getInvoiceNumFromSearch()));
				}

				if (!StringUtils.isEmpty(filter.getInvoiceNumToSearch())) {
					predicates.add(cb.lessThanOrEqualTo(root.get("invoiceNum"), filter.getInvoiceNumToSearch()));
				}

				if (!StringUtils.isEmpty(filter.getClientSearch())) {
					predicates.add(cb.like(cb.lower(root.get("clientName")),
							"%" + filter.getClientSearch().toLowerCase() + "%"));
				}

				if (!StringUtils.isEmpty(filter.getFromDate())) {
					try {
						Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getFromDate());
						predicates.add(cb.greaterThanOrEqualTo((root.get("invoiceDate")), fromDate));
					} catch (ParseException e) {

					}

				}

				if (!StringUtils.isEmpty(filter.getToDate())) {
					try {
						Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getToDate());
						predicates.add(cb.lessThanOrEqualTo((root.get("invoiceDate")), toDate));
					} catch (ParseException e) {

					}

				}

				
				if (!StringUtils.isEmpty(filter.getContractSearch())) {
					predicates.add(cb.like(cb.lower(root.get("contractName")),
							"%" + filter.getContractSearch().toLowerCase() + "%"));
				}
				
				if (filter.getInvoiceStatus()!=0) {
				
					predicates.add(cb.equal(root.get("invoiceStatusValue"),
						 filter.getInvoiceStatus()));
				}
				
				if (!StringUtils.isEmpty(filter.getSapNumber())) {
					predicates.add(cb.like(cb.lower(root.get("sapFileNumber")),
							"%" + filter.getSapNumber().toLowerCase() + "%"));
				}
				
				if (!StringUtils.isEmpty(filter.getPaymentMethod())) {
					predicates.add(cb.like(cb.lower(root.get("paymentMethod")),
							"%" + filter.getPaymentMethod().toLowerCase() + "%"));
				}
				
				if (!StringUtils.isEmpty(filter.getSendMethod())) {
					predicates.add(cb.like(cb.lower(root.get("sendMethod")),
							"%" + filter.getSendMethod().toLowerCase() + "%"));
				}
				
				if (!StringUtils.isEmpty(filter.getToSentDate())) {
					try {
						Date toSentDate = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getToSentDate());
						predicates.add(cb.lessThanOrEqualTo((root.get("sentDate")), toSentDate));
					} catch (ParseException e) {

					}

				}
				
				if (!StringUtils.isEmpty(filter.getFromSentDate())) {
					try {
						Date fromSentDate = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getFromSentDate());
						predicates.add(cb.greaterThanOrEqualTo((root.get("sentDate")), fromSentDate));
					} catch (ParseException e) {

					}

				}
				*/
			

				return cb.and(predicates.toArray(new Predicate[0]));
			}
		};
	
}
}
