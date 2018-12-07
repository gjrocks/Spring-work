package org.baeldung.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class InvoicingUtil {
	
	public boolean isUserLocked(Date dateLockedUntil) {
		if (dateLockedUntil != null) {
			Calendar rightNow = Calendar.getInstance();
			Calendar lockedUntil = Calendar.getInstance();
			lockedUntil.setTime(dateLockedUntil);

			if (lockedUntil.after(rightNow)) {
				return true;
			} 
		}
		return false;
	}
	
	

}
