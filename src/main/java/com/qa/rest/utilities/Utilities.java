package com.qa.rest.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utilities {

	public static String empName() {
		String generateString = RandomStringUtils.randomAlphabetic(2);
		return ("John" + generateString);
	}
	
	public static String empSal() {
		String generateString = RandomStringUtils.randomNumeric(7);
		return (generateString);
	}
	
	public static String empAge() {
		String generateString = RandomStringUtils.randomNumeric(2);
		return (generateString);
		
	}
	
}
