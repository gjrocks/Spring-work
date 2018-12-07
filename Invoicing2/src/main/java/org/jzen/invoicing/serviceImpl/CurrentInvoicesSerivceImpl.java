package org.jzen.invoicing.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jzen.invoicing.bean.CurrentInvoicesBean;
import org.jzen.invoicing.bean.CurrentInvoicesResultsBean;
import org.jzen.invoicing.controller.CurrentInvociesController;
import org.jzen.invoicing.datatable.PagingData;
import org.jzen.invoicing.datatable.PagingGenerator;
import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.entity.InvoiceRunDates;
import org.jzen.invoicing.entity.enums.InvoiceStatus;
import org.jzen.invoicing.entity.enums.PaymentMethodType;
import org.jzen.invoicing.entity.enums.SendMethodType;
import org.jzen.invoicing.repository.CurrentInvoicesRepository;
import org.jzen.invoicing.repository.InvoiceRunRepository;
import org.jzen.invoicing.repository.specification.InvoiceSearchSpecificaton;
import org.jzen.invoicing.service.CurrentInvoicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;

@Service
@Transactional
public class CurrentInvoicesSerivceImpl implements CurrentInvoicesService {

	private static final Logger logger = LoggerFactory.getLogger(CurrentInvoicesSerivceImpl.class);
	@Autowired
	CurrentInvoicesRepository currentInvoicesRepository;

	@Autowired
	InvoiceRunRepository invoiceRunRepository;
	@Autowired
	InvoiceSearchSpecificaton invoiceSearchSpecification;

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	
	public Page<Invoice> searchInvoices(CurrentInvoicesBean filter) {

		Pageable limit = new PageRequest(filter.getPage() - 1, filter.getDisplaySize(), new Sort(filter.getSortBy()));

		Page<Invoice> invoiceResults = currentInvoicesRepository.findAll(invoiceSearchSpecification.findByCriteria(filter), limit);
		logger.debug("*filter.getPage()" + invoiceResults.getNumberOfElements());
		logger.debug("*filter.getDisplaySize()" + filter.getDisplaySize());

		return invoiceResults;
	}

	@Override
	public InvoiceRunDates getCurrentPeriod() {

		Map currentPeriodMap = new HashMap<String, String>();
		InvoiceRunDates currentRunDates = invoiceRunRepository.getCurrentRunDates();
		return currentRunDates;

	}

	@Override
	public PagingData getPagedInvoices(CurrentInvoicesBean currentInvoicesSearchBean) {

		Page<Invoice> invoiceResults = searchInvoices(currentInvoicesSearchBean);
		logger.debug("invoiceResults" + invoiceResults.getSize());
		final PagingData data = new PagingData(currentInvoicesSearchBean.getPage());

		data.setNumResultsPerPage(currentInvoicesSearchBean.getDisplaySize());

		long count;
		count = invoiceResults.getTotalElements();
		logger.debug("count" + count);
		data.setTotalNumResults((int) count);

		if (count > 0) {

			List<CurrentInvoicesResultsBean> currInvResultsBean = new ArrayList<CurrentInvoicesResultsBean>();
			for (Invoice invoice : invoiceResults.getContent()) {

				CurrentInvoicesResultsBean currInvResults = new CurrentInvoicesResultsBean();
				currInvResults.setClientName(invoice.getClientName());
				currInvResults.setContractName(invoice.getContractName());
				currInvResults.setInvoiceNum(invoice.getInvoiceNum());
				currInvResults.setSap(invoice.getSapFileNumber());
				if (null != invoice.getInvoiceDate()) {
					String invDate = dateFormat.format(invoice.getInvoiceDate());
					currInvResults.setInvoiceDate(invDate);
				}
				if (null != invoice.getSentDate()) {
					String sentDate = dateFormat.format(invoice.getSentDate());
					currInvResults.setSentDate(sentDate);
				}
				if (null != invoice.getInvoiceStatusValue()) {
					String invoiceStatus = InvoiceStatus.getStatus(invoice.getInvoiceStatusValue());
					currInvResults.setInvoiceStatus(invoiceStatus);
				}
				if (null != invoice.getPaymentMethod()) {
					String paymentMethod = PaymentMethodType.getPaymentMethod(invoice.getPaymentMethod());
					currInvResults.setPaymentMethod(paymentMethod);
				}
				
				if (null != invoice.getSendMethod()) {
					String sendMethod = SendMethodType.getSendMethod(invoice.getSendMethod());
					currInvResults.setSendMethod(sendMethod);
				}

				currInvResultsBean.add(currInvResults);
			}
			data.setResults(currInvResultsBean);
			PagingGenerator.getInstance().generatePages(data);
		}
		return data;
	}

	@Override
	public List<Invoice> getInvoicesByInvoiceNumList(List<String> invoiceNumList) {
		
		List<Invoice> invNumList=currentInvoicesRepository.getInvoicesByInvoiceNumList(invoiceNumList);
		return invNumList;
				
	}

}
