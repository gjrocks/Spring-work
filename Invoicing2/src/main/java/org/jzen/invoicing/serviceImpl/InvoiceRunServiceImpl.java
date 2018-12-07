package org.jzen.invoicing.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.jzen.invoicing.bean.CurrentInvoicesResultsBean;
import org.jzen.invoicing.bean.InvoiceRunDatesBean;
import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.entity.InvoiceRunDates;
import org.jzen.invoicing.repository.InvoiceRunRepository;
import org.jzen.invoicing.service.InvoiceRunService;
import org.jzen.invoicing.util.InvoicingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InvoiceRunServiceImpl implements InvoiceRunService {

	@Autowired
	InvoiceRunRepository invoiceRunRepository;
	

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public List<InvoiceRunDatesBean> getAllInvoiceRunDates() {
		InvoiceRunDatesBean invRunDateBean = new InvoiceRunDatesBean();
		List<InvoiceRunDatesBean> invRunDatesBeanList = new ArrayList<InvoiceRunDatesBean>();
		List<InvoiceRunDates> invoiceRunDates = invoiceRunRepository.getAllPendingNextRunDates();
		
		for (InvoiceRunDates invRunDate : invoiceRunDates) {
			invRunDateBean = new InvoiceRunDatesBean();
		
			String endDateString = dateFormat.format(invRunDate.getInvoicePeriodEndDate());
			String startDateString = dateFormat.format(invRunDate.getInvoicePeriodStartDate());
			invRunDateBean.setInvoicePeriodEndDate(endDateString);
			invRunDateBean.setInvoicePeriodStartDate(startDateString);
			String period = startDateString + "-" + endDateString;
			invRunDateBean.setInvoiceRunPeriod(period);
			invRunDateBean.setPeriodNum(invRunDate.getId());
			invRunDatesBeanList.add(invRunDateBean);
		}

		return invRunDatesBeanList;

	}
	
	@Transactional
	@Override
	public void updateRunDates(Date prevEndDate , Date currEndDate,Long periodId) {
		if(prevEndDate.compareTo(currEndDate)!=0) {
		    Date nextPeriodStartDate=getNextDayDate(prevEndDate);
		    InvoiceRunDates invDate=invoiceRunRepository.getInvoiceRunDatesByInvoicePeriodStartDate(nextPeriodStartDate);
		    if(null!=invDate) {
		    Long id=invDate.getId();
			Date newNextPeriodStartDate=getNextDayDate(currEndDate);
			invoiceRunRepository.updateInvoiceRunStartDate(newNextPeriodStartDate, id);
		    }
			invoiceRunRepository.updateInvoiceRunEndDate(currEndDate, periodId);
			
		}
	}
	

	
	private Date getNextDayDate(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE,1);
		return cal.getTime();
		
	}

}
