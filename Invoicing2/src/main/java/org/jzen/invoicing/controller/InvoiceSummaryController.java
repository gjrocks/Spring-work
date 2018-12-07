package org.jzen.invoicing.controller;


import org.jzen.invoicing.bean.InvoiceSummaryBean;
import org.jzen.invoicing.service.InvoiceSummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class InvoiceSummaryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InvoiceSummaryController.class);

	@Autowired
	InvoiceSummaryService invoiceSummaryService;
	
	@RequestMapping(value = "showInvoiceSummary/{invoiceNum}", method = RequestMethod.POST)
	public String showInvoiceSummary(@PathVariable(name="invoiceNum", required=true) String invoiceNum , Model model 
			) {
		logger.debug("inside showInvoiceSummary page");
	
		InvoiceSummaryBean invoiceSummaryBean=invoiceSummaryService.getInvoiceSummaryByInvoiceNumber(invoiceNum);
		model.addAttribute("invoiceSummaryBean", invoiceSummaryBean);
		model.addAttribute("productList", invoiceSummaryBean.getInvolicelineitems());
		return "invoiceSummary";
		
	}
	
}
