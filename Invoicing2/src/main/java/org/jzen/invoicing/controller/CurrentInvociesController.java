package org.jzen.invoicing.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;

import org.jzen.invoicing.datatable.PagingGenerator;

import org.jzen.invoicing.bean.CurrentInvoicesBean;
import org.jzen.invoicing.bean.CurrentInvoicesResultsBean;

import org.jzen.invoicing.datatable.PagingData;
import org.jzen.invoicing.datatable.PagingHelper;
import org.jzen.invoicing.entity.EbulkImport;
import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.entity.InvoiceRunDates;
import org.jzen.invoicing.service.CurrentInvoicesService;
import org.jzen.invoicing.service.EbulkImportService;

import org.jzen.invoicing.service.InvoiceSummaryService;

import org.jzen.invoicing.util.InvoiceDownloadHelper;
import org.jzen.invoicing.util.csv.CsvWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import freemarker.template.Configuration;

@Controller
// @RequestMapping(value="invoice")
public class CurrentInvociesController {

	@Autowired
	Configuration freemarkerConfig;
	@Autowired
	private CurrentInvoicesService currentInvociesService;
	@Autowired
	InvoiceSummaryService invoiceSummaryService;
	@Autowired
	InvoiceDownloadHelper invoiceDownloadHelper;
	@Autowired
	EbulkImportService ebulkImportService;
	private static final String SHOW_SEARCH_RESULTS = "showSearchResults";
	private static final String CURRENT_INVOICES_BEAN = "currentInvoicesBean";
	private static final String CURRENT_INVOICES = "currentInvoices";
	private static final String MESSAGE = "message";
	private static final String SHOW_ERROR = "showError";

	private static final Logger logger = LoggerFactory.getLogger(CurrentInvociesController.class);

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


	@RequestMapping(value = CURRENT_INVOICES, method = RequestMethod.GET)
	public String showCurrentInvoicesHomePage(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("inside showCurrentInvoicesHomePage page");

		model.addAttribute(SHOW_SEARCH_RESULTS, false);
		CurrentInvoicesBean currentInvoicesBean = new CurrentInvoicesBean();
		model.addAttribute(CURRENT_INVOICES_BEAN, setCurrentInvoicesBeanDefaultValues(currentInvoicesBean));
		return CURRENT_INVOICES;

	}

	@RequestMapping(value = "searchCurrentInvoices", method = RequestMethod.POST)
	public String searchCurrentInvoices(@RequestParam(name = "page") Integer page,
			@Valid @ModelAttribute(CURRENT_INVOICES_BEAN) CurrentInvoicesBean currentInvoices, BindingResult result,
			Model model, HttpServletRequest request) {
		currentInvoices.setPage(page);
		if (StringUtils.isEmpty(currentInvoices.getFromDate())) {
			InvoiceRunDates invoiceRunDates = currentInvociesService.getCurrentPeriod();
			Date periodStartDate = invoiceRunDates.getInvoicePeriodStartDate();
			String startDate = dateFormat.format(periodStartDate);
			currentInvoices.setFromDate(startDate);
		}
		if (StringUtils.isEmpty(currentInvoices.getToDate())) {
			InvoiceRunDates invoiceRunDates = currentInvociesService.getCurrentPeriod();
			Date periodEndDate = invoiceRunDates.getInvoicePeriodEndDate();
			String endDate = dateFormat.format(periodEndDate);
			currentInvoices.setToDate(endDate);
		}
		logger.debug("inside searchCurrentInvoices page");

		if (result.hasErrors()) {
			model.addAttribute(CURRENT_INVOICES_BEAN, setCurrentInvoicesBeanDefaultValues(currentInvoices));
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute(SHOW_SEARCH_RESULTS, false);
			model.addAttribute(MESSAGE, result.getAllErrors().get(0).getDefaultMessage());
			return CURRENT_INVOICES;
		}

		PagingData data = currentInvociesService.getPagedInvoices(currentInvoices);
		PagingHelper.assignPagingAttributes(data, request.getPathInfo(), request);
		if (data == null || data.getResults() == null || data.getResults().isEmpty()) {
			model.addAttribute(SHOW_SEARCH_RESULTS, false);
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute(CURRENT_INVOICES_BEAN, setCurrentInvoicesBeanDefaultValues(currentInvoices));
			model.addAttribute(MESSAGE, "No data matches entered search criteria");
			return CURRENT_INVOICES;
		}
		setCurrentInvoicesBeanDefaultValues(currentInvoices);
		currentInvoices.setPage(page);
		model.addAttribute(CURRENT_INVOICES_BEAN, currentInvoices);
		model.addAttribute("invoiceResultsList", data.getResults());
		model.addAttribute("invoiceResultsBean", new CurrentInvoicesResultsBean());
		model.addAttribute(SHOW_SEARCH_RESULTS, true);

		return CURRENT_INVOICES;

	}

	@RequestMapping(value = "resetSearch", method = RequestMethod.POST)
	public String resetSearch(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("inside resetSearch");
		model.addAttribute(SHOW_SEARCH_RESULTS, false);
		CurrentInvoicesBean currentInvoicesBean = new CurrentInvoicesBean();
		model.addAttribute(CURRENT_INVOICES_BEAN, setCurrentInvoicesBeanDefaultValues(currentInvoicesBean));
		return CURRENT_INVOICES;
	}

	private CurrentInvoicesBean setCurrentInvoicesBeanDefaultValues(CurrentInvoicesBean currentInvoicesBean) {

		InvoiceRunDates invoiceRunDates = currentInvociesService.getCurrentPeriod();
		Map<String, String> sortBymap = new HashMap<String, String>();
		sortBymap.put("invoiceNum", "Invoice Number");
		sortBymap.put("contractName", "Contract");
		sortBymap.put("clientName", "Client");
		sortBymap.put("invoiceDate", "Invoice Date");
		sortBymap.put("invoiceStatusValue", "Invoice Status");
		sortBymap.put("sentDate", "Sent Date");
		sortBymap.put("paymentMethod", "Payment method");
		sortBymap.put("sendMethod", "Sent Method");
		sortBymap.put("sapFileNumber", "SAP File Number");
		currentInvoicesBean.setSortByMap(sortBymap);

		Map<Integer, String> invoiceStatusmap = new HashMap<Integer, String>();
		invoiceStatusmap.put(0, "All");
		invoiceStatusmap.put(1, "Pending");
		invoiceStatusmap.put(2, "Authorised");
		invoiceStatusmap.put(3, "Cancelled");
		invoiceStatusmap.put(4, "Sent");
		invoiceStatusmap.put(5, "Regenerated");
		currentInvoicesBean.setInvoiceStatusMap(invoiceStatusmap);

		Date periodStartDate = invoiceRunDates.getInvoicePeriodStartDate();
		Date periodEndDate = invoiceRunDates.getInvoicePeriodEndDate();
		String startDate = dateFormat.format(periodStartDate);
		String endDate = dateFormat.format(periodEndDate);

		currentInvoicesBean.setPage(1);
		currentInvoicesBean.setFromDate(startDate);
		currentInvoicesBean.setToDate(endDate);
		return currentInvoicesBean;
	}

	@RequestMapping(value = "downloadInvoicePdf", method = RequestMethod.POST)
	public void downloadInvoicePdf(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		logger.debug("inside downloadInvoicePdf page");
		String[] invoiceIdArray = request.getParameterValues("id");
		if (null == invoiceIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Invoice_" + today + ".zip";
		StringBuilder imagePath = new StringBuilder();
		imagePath.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
				.append(request.getServerPort());
		if (request.getContextPath() != "") {
			imagePath.append("/").append(request.getContextPath());
		}
		imagePath.append("/images/").append("security-logo.jpg");
		List<Invoice> invoiceList=currentInvociesService.getInvoicesByInvoiceNumList(Arrays.asList(invoiceIdArray));
		invoiceDownloadHelper.downloadInvoices(invoiceList, zipFileName, imagePath.toString(), response, 1);

	}

	@RequestMapping(value = "downloadInvoiceBackingPdf", method = RequestMethod.POST)
	public void downloadInvoiceBackingPdf(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		logger.debug("inside downloadInvoiceBackingPdf page");
		String[] invoiceIdArray = request.getParameterValues("id");
		if (null == invoiceIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Invoice_" + today + ".zip";
		List<Invoice> invoiceList=currentInvociesService.getInvoicesByInvoiceNumList(Arrays.asList(invoiceIdArray));
		invoiceDownloadHelper.downloadInvoices(invoiceList, zipFileName, "", response, 0);

	}

	@RequestMapping(value = "downloadInvoiceBackingcsv", method = RequestMethod.POST)
	public void downloadInvoiceBackingCsv(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		logger.debug("inside downloadInvoiceBackingcsv page");
		String[] invoiceIdArray = request.getParameterValues("id");
		if (null == invoiceIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Invoice_" + today + ".zip";
		List<Invoice> invoiceList=currentInvociesService.getInvoicesByInvoiceNumList(Arrays.asList(invoiceIdArray));
		invoiceDownloadHelper.downloadInvoices(invoiceList, zipFileName, "", response, 3);
	}

	@RequestMapping(value = "generateInvoiceFolders", method = RequestMethod.POST)
	public void generateInvoiceFolders(@ModelAttribute(CURRENT_INVOICES_BEAN) CurrentInvoicesBean currentInvoices,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		logger.debug("inside generateInvoiceFolders page" + currentInvoices);
		String[] invoiceIdArray = request.getParameterValues("id");
	
		if (null == invoiceIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Invoice_" + today + ".zip";
		StringBuilder imagePath = new StringBuilder();
		imagePath.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
				.append(request.getServerPort());
		if (request.getContextPath() != "") {
			imagePath.append("/").append(request.getContextPath());
		}
		imagePath.append("/images/").append("security-logo.jpg");
		
		try {
			List<Invoice> invoiceList=currentInvociesService.getInvoicesByInvoiceNumList(Arrays.asList(invoiceIdArray));
			invoiceDownloadHelper.downloadInvoices(invoiceList, zipFileName, imagePath.toString(), response, 2);
		} catch (IOException e) {
			logger.debug("exception occured while download" + e);
		}
	}

	@RequestMapping(value = "generateExcelReport", method = RequestMethod.POST)
	public void generateExcelReport(@ModelAttribute(CURRENT_INVOICES_BEAN) CurrentInvoicesBean currentInvoices,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		PagingData pagedResults = currentInvociesService.getPagedInvoices(currentInvoices);
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "max-age=0");
		response.addHeader("expires", "0");
		String title = "report";
		response.setHeader("CONTENT-DISPOSITION", "attachment; filename=" + title + ".csv");
		final CsvWriter csv = new CsvWriter(response.getOutputStream());
		List<String> values = new ArrayList<String>();
		values.add("Invoice Number");
		values.add("Client");
		values.add("Contract");
		values.add("Invoice Date");
		values.add("Invoice Status");
		values.add("Payment Method");
		values.add("Send Method");
		values.add("Sent Date");
		values.add("SAP");
		final Collection fieldValues = values;

		try {
			csv.writeln((String[]) fieldValues.toArray(new String[fieldValues.size()]));
		} catch (IOException e1) {

		}
		List<CurrentInvoicesResultsBean> results = pagedResults.getResults();
		if (results != null) {
			for (CurrentInvoicesResultsBean obj : results) {
				List<String> data = new ArrayList();
				data.add(obj.getInvoiceNum());
				data.add(obj.getClientName());
				data.add(obj.getContractName());
				data.add(obj.getInvoiceDate());
				data.add(obj.getInvoiceStatus());
				data.add(obj.getPaymentMethod());
				data.add(obj.getSendMethod());
				data.add(obj.getSentDate());
				data.add(obj.getSap());
				try {
					csv.writeln(data.toArray(new String[data.size()]));
				} catch (IOException e) {

				}
			}
		}
		return;
	}
	
//	public String sendMail(HttpServletRequest request, HttpServletResponse response) {
//		String[] invoiceIdArray = request.getParameterValues("id");
//		//method to get list of send method
//		for(int i=0;i<invoiceIdArray.length;i++) {
//			String invoiceNum=invoiceIdArray[i];
//			
//		}
		
		
		
//	}

}
