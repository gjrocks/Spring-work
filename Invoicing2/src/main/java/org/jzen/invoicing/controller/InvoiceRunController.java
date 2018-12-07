package org.jzen.invoicing.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.jzen.invoicing.bean.CurrentInvoicesBean;
import org.jzen.invoicing.bean.InvoiceRunDatesBean;
import org.jzen.invoicing.bean.InvoiceRunDatesWrapper;
import org.jzen.invoicing.bean.InvoiceSummaryBean;
import org.jzen.invoicing.service.CurrentInvoicesService;
import org.jzen.invoicing.service.InvoiceRunService;
import org.jzen.invoicing.util.DateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InvoiceRunController {

	@Autowired
	private InvoiceRunService invoiceRunService;

	private static final Logger logger = LoggerFactory.getLogger(InvoiceRunController.class);

	@RequestMapping(value = "showInvoiceRunDates", method = RequestMethod.GET)
	public String showInvoiceRunDates(Model model, HttpServletRequest request, HttpServletResponse response,String message,String errorMessage) {
		logger.debug("inside showInvoiceRunDates page");
		List<InvoiceRunDatesBean> invDatesBeanList = invoiceRunService.getAllInvoiceRunDates();
		InvoiceRunDatesWrapper invoiceRunDatesWrapper = new InvoiceRunDatesWrapper();
		invoiceRunDatesWrapper.setInvoiceRunDatesList(invDatesBeanList);
		if(message!=null) {
			model.addAttribute("showMessage", true);
			model.addAttribute("message", "Invoice period run dates have been updated.");
		}
		
		InvoiceRunDatesBean invoiceRunDatesBean = new InvoiceRunDatesBean();
		model.addAttribute("invoiceRunDatesWrapper", invoiceRunDatesWrapper);
		model.addAttribute("invoiceRunDatesBean", invoiceRunDatesBean);
		model.addAttribute("showSelectedDates", false);
		return "invoiceRunDates";

	}

	@RequestMapping(value = "getPeriod/{periodNum}", method = RequestMethod.POST)
	public String showPeriodData(@PathVariable(name = "periodNum", required = true) Long periodNum, Model model,
			@ModelAttribute("invoiceRunDatesWrapper") InvoiceRunDatesWrapper invoiceRunDatesWrapper) {
		logger.debug("inside showPeriodData page");
		List<InvoiceRunDatesBean> invDatesBeanList = invoiceRunDatesWrapper.getInvoiceRunDatesList();
		InvoiceRunDatesBean invoiceRunDatesBean = new InvoiceRunDatesBean();
		
		for (InvoiceRunDatesBean invRunBean : invDatesBeanList) {
			if (invRunBean.getPeriodNum().equals(periodNum)) {
				invoiceRunDatesBean.setInvoicePeriodEndDate(invRunBean.getInvoicePeriodEndDate());
				invoiceRunDatesBean.setInvoicePeriodStartDate(invRunBean.getInvoicePeriodStartDate());
				invoiceRunDatesBean.setInvoiceRunPeriod(invRunBean.getInvoiceRunPeriod());
				invoiceRunDatesBean.setPrevInvoicePeriodEndDate(invRunBean.getInvoicePeriodEndDate());
				invoiceRunDatesBean.setPrevInvoicePeriodStartDate(invRunBean.getInvoicePeriodStartDate());
				invoiceRunDatesBean.setPeriodNum(invRunBean.getPeriodNum());
				}
		}
		model.addAttribute("invoiceRunDatesList", invDatesBeanList);
		model.addAttribute("invoiceRunDatesBean", invoiceRunDatesBean);
		model.addAttribute("showSelectedDates", true);
		return "invoiceRunDates";

	}

	@RequestMapping(value = "modifyDates", method = RequestMethod.POST)
	public String modifyRunDates(@Valid @ModelAttribute("invoiceRunDatesBean") InvoiceRunDatesBean invoiceRunDatesBean, BindingResult result,Model model) {
		logger.debug("inside modifyRunDates page");
		Long periodNum = invoiceRunDatesBean.getPeriodNum();
		if (result.hasErrors()) {
			String invStartDate=invoiceRunDatesBean.getPrevInvoicePeriodStartDate();
			invoiceRunDatesBean.setInvoicePeriodStartDate(invStartDate);
			List<InvoiceRunDatesBean> invDatesBeanList = invoiceRunService.getAllInvoiceRunDates();
			InvoiceRunDatesWrapper invoiceRunDatesWrapper = new InvoiceRunDatesWrapper();
			invoiceRunDatesWrapper.setInvoiceRunDatesList(invDatesBeanList);
				model.addAttribute("showErrorMessage", true);
				model.addAttribute("errorMessage", result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("invoiceRunDatesWrapper", invoiceRunDatesWrapper);
				model.addAttribute("invoiceRunDatesBean", invoiceRunDatesBean);
				model.addAttribute("showSelectedDates", true);
			return "invoiceRunDates";
			
			
		}
		
		
		Date prevEndDate = DateWrapper.convertStringToDate(invoiceRunDatesBean.getPrevInvoicePeriodEndDate());
	
		Date currEndDate = DateWrapper.convertStringToDate(invoiceRunDatesBean.getInvoicePeriodEndDate());
		invoiceRunService.updateRunDates(prevEndDate, currEndDate, periodNum);
		logger.debug("dates updated");
		return "redirect:/showInvoiceRunDates?message";
		

	}

}
