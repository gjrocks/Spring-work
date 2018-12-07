package org.jzen.invoicing.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.jzen.invoicing.entity.InvoiceRunDates;
import org.jzen.invoicing.service.CurrentInvoicesService;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrentInvoicesDatePeriodValidator
		implements ConstraintValidator<CurrentInvoicesDatePeriodConstraint, Object> {
	private String fromDate;
	private String toDate;

	@Autowired
	CurrentInvoicesService currentInvoicesService;

	@Override
	public void initialize(CurrentInvoicesDatePeriodConstraint dateRange) {
		this.fromDate = dateRange.start();
		this.toDate = dateRange.end();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {

		try {
			final Object fromDateObj = PropertyUtils.getProperty(value, this.fromDate);
			final Object toDateObj = PropertyUtils.getProperty(value, this.toDate);

			InvoiceRunDates invoiceRunDates = currentInvoicesService.getCurrentPeriod();
			if (!(fromDateObj == null || fromDateObj.equals(""))) {
				Date periodStartDate = invoiceRunDates.getInvoicePeriodStartDate();
				Date fromDateVal = new SimpleDateFormat("dd/MM/yyyy").parse((String) fromDateObj);
				if (fromDateVal.compareTo(periodStartDate) < 0) {
					return false;
				}
			}

			if (!(toDateObj == null || toDateObj.equals(""))) {
				Date periodEndDate = invoiceRunDates.getInvoicePeriodEndDate();
				Date toDateVal = new SimpleDateFormat("dd/MM/yyyy").parse((String) toDateObj);
				if (periodEndDate.compareTo(toDateVal) < 0) {
					return false;
				}
			}

			return true;

		} catch (final Exception ex) {

			return false;
		}

	}

}
