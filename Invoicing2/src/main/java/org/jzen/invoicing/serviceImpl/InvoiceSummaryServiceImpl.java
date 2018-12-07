package org.jzen.invoicing.serviceImpl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.jzen.invoicing.bean.CurrentInvoicesBean;
import org.jzen.invoicing.bean.EntityAddressBean;
import org.jzen.invoicing.bean.InvoiceLineItemsBean;
import org.jzen.invoicing.bean.InvoiceSummaryBean;
import org.jzen.invoicing.entity.Contract;
import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.entity.InvoiceLineItems;
import org.jzen.invoicing.entity.enums.InvoiceStatus;
import org.jzen.invoicing.repository.CurrentInvoicesRepository;
import org.jzen.invoicing.service.InvoiceSummaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceSummaryServiceImpl implements InvoiceSummaryService {

	@Autowired
	CurrentInvoicesRepository currentInvoicesRepository;

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public InvoiceSummaryBean getInvoiceSummaryByInvoiceNumber(String invoiceNumber) {

		InvoiceSummaryBean invoiceSummaryBean = new InvoiceSummaryBean();
		CurrentInvoicesBean filter = new CurrentInvoicesBean();
		filter.setInvoiceNumSearch(invoiceNumber);
		Invoice summaryBean = currentInvoicesRepository.getInvoiceByInvoiceNum(invoiceNumber);
		Contract contract = summaryBean.getContract();
		invoiceSummaryBean.setInvoiceNumber(summaryBean.getInvoiceNum());
		if (null != summaryBean.getInvoiceDate()) {
			String invDate = dateFormat.format(summaryBean.getInvoiceDate());
			invoiceSummaryBean.setInvoiceDate(invDate);
		}
		if (null != summaryBean.getSentDate()) {
			String sentDate = dateFormat.format(summaryBean.getSentDate());
			invoiceSummaryBean.setSentDate(sentDate);
		}
		if (null != summaryBean.getInvoiceStatusValue()) {
			String invoiceStatus = InvoiceStatus.getStatus(summaryBean.getInvoiceStatusValue());
			invoiceSummaryBean.setInvoiceStatus(invoiceStatus);
		}
		invoiceSummaryBean.setIsManual(summaryBean.gettIsManual());
		invoiceSummaryBean.setBusinessContact(summaryBean.getContract().getBusinessContact());
		invoiceSummaryBean.setClientName(summaryBean.getClientName());
		invoiceSummaryBean.setContractName(contract.getContractName());
		//invoiceSummaryBean.setPoNumber(contract.getpo);
		invoiceSummaryBean.setSapClientCode(contract.getClientSAPCode());
		invoiceSummaryBean.setSendMethod(summaryBean.getSendMethod());
		 invoiceSummaryBean.setTotalGrossSummary(summaryBean.getGross());
		invoiceSummaryBean.setTotalNetSummary(summaryBean.getNet());
		 invoiceSummaryBean.setTotalVatSummary(summaryBean.getVat());
		EntityAddressBean entityAddressBean = new EntityAddressBean();
		entityAddressBean.setAddressName(contract.getAddress1());
		entityAddressBean.setBuildingName(contract.getAddress2());
		entityAddressBean.setStreetName(contract.getAddress3());
		entityAddressBean.setTown(contract.getAddress4());
		entityAddressBean.setCounty(contract.getAddress5());
		entityAddressBean.setPostCode(contract.getAddress6());
		entityAddressBean.setCountry(contract.getAddress7());
		invoiceSummaryBean.setBillingAddress(entityAddressBean);
		InvoiceLineItemsBean invoiceLineItemBean = new InvoiceLineItemsBean();
		Set<InvoiceLineItems> invoiceLineItems = summaryBean.getInvoiceLineItems();
		List<InvoiceLineItemsBean> invoiceLineItemBeanlist = new ArrayList<InvoiceLineItemsBean>();
		for (InvoiceLineItems invoiceLineItem:invoiceLineItems) {
			invoiceLineItemBean = new InvoiceLineItemsBean();
			invoiceLineItemBean.setItemGross(invoiceLineItem.getGross());
			invoiceLineItemBean.setItemNet(invoiceLineItem.getNet());
			invoiceLineItemBean.setItemVat(invoiceLineItem.getVat());
			invoiceLineItemBean.setQuantity(invoiceLineItem.getQuantity());
			invoiceLineItemBean.setTotalGross(invoiceLineItem.getTotalGross());
			invoiceLineItemBean.setTotalNet(invoiceLineItem.getTotalNet());
			invoiceLineItemBean.setTotalVat(invoiceLineItem.getTotalVat());
			
			invoiceLineItemBean.setProductName(invoiceLineItem.getLineItemName());
			invoiceLineItemBeanlist.add(invoiceLineItemBean);
		}
		invoiceSummaryBean.setInvolicelineitems(invoiceLineItemBeanlist);
		return invoiceSummaryBean;
	}

}
