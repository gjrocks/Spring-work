package org.jzen.invoicing.util;

import org.apache.commons.lang.RandomStringUtils;

public class RandomUtil {

	public String getRandomAlphaNumric(int length) {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return generatedString;
	}
	
	
}
