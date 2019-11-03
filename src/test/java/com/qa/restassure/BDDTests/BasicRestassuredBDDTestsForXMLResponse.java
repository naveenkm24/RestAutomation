package com.qa.restassure.BDDTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.Matchers.containsString;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.hamcrest.xml.HasXPath;

import com.qa.rest.testing.TestBase.BaseTest;

public class BasicRestassuredBDDTestsForXMLResponse extends BaseTest {
	
	@Test
	void testSingleContent() {
		
		logger.info("********* verify single content response using BDD approach *********");
		
		given().
		when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15").
		then().body("CUSTOMER.ID", equalTo("15")).
		log().all();
	}
	
	@Test
	void testMultipleContent() {
		
		logger.info("********* verify multiple content response using BDD approach *********");
		
		given().
		when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15").
		then().body("CUSTOMER.ID", equalTo("15")).
		body("CUSTOMER.FIRSTNAME", equalTo("Bill")).
		body("CUSTOMER.LASTNAME", equalTo("Clancy")).
		body("CUSTOMER.CITY", equalTo("Seattle"));
	}
	
	@Test
	void testMultipleContentUsingTextMethod() {
		
		logger.info("********* verify multiple content using text() method using BDD approach *********");
		
		given().	
		when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15").
		then().body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle")); 
		//text() method will take the entire xml as single string, however this test will fail if
		// we do not take entire text in xml for validation.
	}
	
	@Test
	void testUsingXpath() {
		
		logger.info("********* verify content using xpath BDD approach *********");
		
		given().
		when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15").
		then().body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
	}
	
	@Test
	void testUsingXpathTwo() {
		
		logger.info("********* verify content using xpath second example, BDD approach *********");
		
		given().
		when().get("http://thomas-bayer.com/sqlrest/INVOICE/").
		then().body(hasXPath("/INVOICEList/INVOICE[text()='24']"));
		
		logger.info("********* Completed test using xpath verification technique *********");
	}

}
