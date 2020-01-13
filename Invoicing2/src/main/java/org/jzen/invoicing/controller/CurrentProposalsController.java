package org.jzen.invoicing.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.jzen.invoicing.bean.CurrentProposalsBean;
import org.jzen.invoicing.bean.CurrentProposalsResultsBean;
import org.jzen.invoicing.datatable.PagingData;
import org.jzen.invoicing.datatable.PagingHelper;
//import org.jzen.invoicing.entity.ProposalRunDates;
import org.jzen.invoicing.service.CurrentProposalsService;
import org.jzen.invoicing.service.EbulkImportService;
import org.jzen.invoicing.service.ProposalSummaryService;
import org.jzen.invoicing.service.UserService;
import org.jzen.invoicing.util.ProposalDownloadHelper;
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
// @RequestMapping(value="Proposal")
public class CurrentProposalsController {

	@Autowired
	Configuration freemarkerConfig;
	@Autowired
	private CurrentProposalsService currentInvociesService;
	//@Autowired
	//ProposalSummaryService ProposalSummaryService;
	@Autowired
	ProposalDownloadHelper ProposalDownloadHelper;
	@Autowired
	EbulkImportService ebulkImportService;
	
	@Autowired
	private UserService userService;
	
	private static final String SHOW_SEARCH_RESULTS = "showSearchResults";
	private static final String CURRENT_ProposalS_BEAN = "currentProposalsBean";
	private static final String CURRENT_ProposalS = "currentProposals";
	private static final String CURRENT_ProposalS2 = "currentProposals2";
	private static final String MESSAGE = "message";
	private static final String SHOW_ERROR = "showError";

	private static final Logger logger = LoggerFactory.getLogger(CurrentProposalsController.class);

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	


	@RequestMapping(value = CURRENT_ProposalS2, method = RequestMethod.GET)
	public String showCurrentProposalsHomePage(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("inside showCurrentProposalsHomePage page");
	
		model.addAttribute(SHOW_SEARCH_RESULTS, false);
		CurrentProposalsBean currentProposalsBean = new CurrentProposalsBean();
		model.addAttribute(CURRENT_ProposalS_BEAN, setCurrentProposalsBeanDefaultValues(currentProposalsBean));
		model.addAttribute("userNameList", null );
		//userService.
		 return CURRENT_ProposalS;

	}

	@RequestMapping(value = "searchCurrentProposals", method = RequestMethod.POST)
	public String searchCurrentProposals(@RequestParam(name = "page") Integer page,
			@Valid @ModelAttribute(CURRENT_ProposalS_BEAN) CurrentProposalsBean currentProposals, BindingResult result,
			Model model, HttpServletRequest request) {
		currentProposals.setPage(page);
		
		logger.debug("inside searchCurrentProposals page");

		if (result.hasErrors()) {
			model.addAttribute(CURRENT_ProposalS_BEAN, setCurrentProposalsBeanDefaultValues(currentProposals));
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute(SHOW_SEARCH_RESULTS, false);
			model.addAttribute(MESSAGE, result.getAllErrors().get(0).getDefaultMessage());
			return CURRENT_ProposalS;
		}

		PagingData data = currentInvociesService.getPagedProposals(currentProposals);
		PagingHelper.assignPagingAttributes(data, request.getPathInfo(), request);
		if (data == null || data.getResults() == null || data.getResults().isEmpty()) {
			model.addAttribute(SHOW_SEARCH_RESULTS, false);
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute(CURRENT_ProposalS_BEAN, setCurrentProposalsBeanDefaultValues(currentProposals));
			model.addAttribute(MESSAGE, "No data matches entered search criteria");
			return CURRENT_ProposalS;
		}
		setCurrentProposalsBeanDefaultValues(currentProposals);
		currentProposals.setPage(page);
		model.addAttribute(CURRENT_ProposalS_BEAN, currentProposals);
		model.addAttribute("proposalResultsList", data.getResults());
		model.addAttribute("proposalResultsBean", new CurrentProposalsResultsBean());
		model.addAttribute(SHOW_SEARCH_RESULTS, true);

		return CURRENT_ProposalS;

	}

	@RequestMapping(value = "resetSearch", method = RequestMethod.POST)
	public String resetSearch(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("inside resetSearch");
		model.addAttribute(SHOW_SEARCH_RESULTS, false);
		CurrentProposalsBean currentProposalsBean = new CurrentProposalsBean();
		model.addAttribute(CURRENT_ProposalS_BEAN, setCurrentProposalsBeanDefaultValues(currentProposalsBean));
		return CURRENT_ProposalS;
	}

	private CurrentProposalsBean setCurrentProposalsBeanDefaultValues(CurrentProposalsBean currentProposalsBean) {

		//ProposalRunDates ProposalRunDates = currentInvociesService.getCurrentPeriod();
		Map<String, String> sortBymap = new HashMap<String, String>();
		sortBymap.put("agreementNumber", "Proposal Number");
		sortBymap.put("createdAt", "Created Date");
		/*sortBymap.put("contractName", "Contract");
		sortBymap.put("clientName", "Client");
		sortBymap.put("ProposalDate", "Proposal Date");
		sortBymap.put("ProposalStatusValue", "Proposal Status");
		sortBymap.put("sentDate", "Sent Date");
		sortBymap.put("paymentMethod", "Payment method");
		sortBymap.put("sendMethod", "Sent Method");
		sortBymap.put("sapFileNumber", "SAP File Number");*/
		currentProposalsBean.setSortByMap(sortBymap);

		Map<Integer, String> ProposalStatusmap = new HashMap<Integer, String>();
		ProposalStatusmap.put(0, "All");
		ProposalStatusmap.put(1, "Pending");
		ProposalStatusmap.put(2, "Authorised");
		ProposalStatusmap.put(3, "Cancelled");
		ProposalStatusmap.put(4, "Sent");
		ProposalStatusmap.put(5, "Regenerated");
		currentProposalsBean.setInvoiceStatusMap(ProposalStatusmap);

		//Date periodStartDate = ProposalRunDates.getProposalPeriodStartDate();
		//Date periodEndDate = ProposalRunDates.getProposalPeriodEndDate();
		String startDate = dateFormat.format(new Date());
		String endDate = dateFormat.format(new Date());

		currentProposalsBean.setPage(1);
		currentProposalsBean.setFromDate(startDate);
		currentProposalsBean.setToDate(endDate);
		return currentProposalsBean;
	}

/*	@RequestMapping(value = "downloadProposalPdf", method = RequestMethod.POST)
	public void downloadProposalPdf(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		logger.debug("inside downloadProposalPdf page");
		String[] ProposalIdArray = request.getParameterValues("id");
		if (null == ProposalIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Proposal_" + today + ".zip";
		StringBuilder imagePath = new StringBuilder();
		imagePath.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
				.append(request.getServerPort());
		if (request.getContextPath() != "") {
			imagePath.append("/").append(request.getContextPath());
		}
		imagePath.append("/images/").append("security-logo.jpg");
		List<Proposal> ProposalList=currentInvociesService.getProposalsByProposalNumList(Arrays.asList(ProposalIdArray));
		ProposalDownloadHelper.downloadProposals(ProposalList, zipFileName, imagePath.toString(), response, 1);

	} */

/*	@RequestMapping(value = "downloadProposalBackingPdf", method = RequestMethod.POST)
	public void downloadProposalBackingPdf(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		logger.debug("inside downloadProposalBackingPdf page");
		String[] ProposalIdArray = request.getParameterValues("id");
		if (null == ProposalIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Proposal_" + today + ".zip";
		List<Proposal> ProposalList=currentInvociesService.getProposalsByProposalNumList(Arrays.asList(ProposalIdArray));
		ProposalDownloadHelper.downloadProposals(ProposalList, zipFileName, "", response, 0);

	}

	@RequestMapping(value = "downloadProposalBackingcsv", method = RequestMethod.POST)
	public void downloadProposalBackingCsv(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		logger.debug("inside downloadProposalBackingcsv page");
		String[] ProposalIdArray = request.getParameterValues("id");
		if (null == ProposalIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Proposal_" + today + ".zip";
		List<Proposal> ProposalList=currentInvociesService.getProposalsByProposalNumList(Arrays.asList(ProposalIdArray));
		ProposalDownloadHelper.downloadProposals(ProposalList, zipFileName, "", response, 3);
	}

	@RequestMapping(value = "generateProposalFolders", method = RequestMethod.POST)
	public void generateProposalFolders(@ModelAttribute(CURRENT_ProposalS_BEAN) CurrentProposalsBean currentProposals,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		logger.debug("inside generateProposalFolders page" + currentProposals);
		String[] ProposalIdArray = request.getParameterValues("id");
	
		if (null == ProposalIdArray) {
			return;
		}
		Calendar cal = Calendar.getInstance();
		String today = dateFormat.format(cal.getTime());
		String zipFileName = "Proposal_" + today + ".zip";
		StringBuilder imagePath = new StringBuilder();
		imagePath.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
				.append(request.getServerPort());
		if (request.getContextPath() != "") {
			imagePath.append("/").append(request.getContextPath());
		}
		imagePath.append("/images/").append("security-logo.jpg");
		
		try {
			List<Proposal> ProposalList=currentInvociesService.getProposalsByProposalNumList(Arrays.asList(ProposalIdArray));
			ProposalDownloadHelper.downloadProposals(ProposalList, zipFileName, imagePath.toString(), response, 2);
		} catch (IOException e) {
			logger.debug("exception occured while download" + e);
		}
	}

	@RequestMapping(value = "generateExcelReport", method = RequestMethod.POST)
	public void generateExcelReport(@ModelAttribute(CURRENT_ProposalS_BEAN) CurrentProposalsBean currentProposals,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		PagingData pagedResults = currentInvociesService.getPagedProposals(currentProposals);
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "max-age=0");
		response.addHeader("expires", "0");
		String title = "report";
		response.setHeader("CONTENT-DISPOSITION", "attachment; filename=" + title + ".csv");
		final CsvWriter csv = new CsvWriter(response.getOutputStream());
		List<String> values = new ArrayList<String>();
		values.add("Proposal Number");
		values.add("Client");
		values.add("Contract");
		values.add("Proposal Date");
		values.add("Proposal Status");
		values.add("Payment Method");
		values.add("Send Method");
		values.add("Sent Date");
		values.add("SAP");
		final Collection fieldValues = values;

		try {
			csv.writeln((String[]) fieldValues.toArray(new String[fieldValues.size()]));
		} catch (IOException e1) {

		}
		List<CurrentProposalsResultsBean> results = pagedResults.getResults();
		if (results != null) {
			for (CurrentProposalsResultsBean obj : results) {
				List<String> data = new ArrayList();
				data.add(obj.getProposalNum());
				data.add(obj.getClientName());
				data.add(obj.getContractName());
				data.add(obj.getProposalDate());
				data.add(obj.getProposalStatus());
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
	}*/
	
//	public String sendMail(HttpServletRequest request, HttpServletResponse response) {
//		String[] ProposalIdArray = request.getParameterValues("id");
//		//method to get list of send method
//		for(int i=0;i<ProposalIdArray.length;i++) {
//			String ProposalNum=ProposalIdArray[i];
//			
//		}
		
		
		
//	}

}
