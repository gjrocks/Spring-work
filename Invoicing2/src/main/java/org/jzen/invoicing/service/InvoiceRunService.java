package org.jzen.invoicing.service;

import java.util.Date;
import java.util.List;

import org.jzen.invoicing.bean.InvoiceRunDatesBean;

public interface InvoiceRunService {

	List<InvoiceRunDatesBean> getAllInvoiceRunDates();

	void updateRunDates(Date prevEndDate, Date currEndDate, Long periodId);

}
