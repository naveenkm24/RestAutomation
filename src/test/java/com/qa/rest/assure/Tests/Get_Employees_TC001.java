package com.qa.rest.assure.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.rest.testing.TestBase.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Get_Employees_TC001 extends BaseTest {

	@BeforeClass
	public void getAllEmployees() throws InterruptedException {
		
		logger.info("*********** Started Test Case Get_Employees_TC001 ***********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		
		Thread.sleep(3);
	}
	
	@Test
	public void checkResponseBody() {
		
		logger.info("*********** Checking Response Body ***********");
		
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void checkStatusCode() {
		
		logger.info("*********** Checking Status Code ***********");
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
	}
	
	@Test
	public void checkResponseTime() {
		
		logger.info("*********** Checking Status Code ***********");
		
		long responseTime = response.getTime();
		logger.info("Response Time is: " + responseTime);
		
		if(responseTime > 9000)
		logger.info("Response time is greater than 2000");
		
		Assert.assertTrue(responseTime < 15000);
	}
	
	@Test
	public void checkStatusLine() {
		
		logger.info("*********** Checking Status Line ***********");
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void checkContentType() {
		
		logger.info("*********** Checking Content Type ***********");
		
		String contentType = response.contentType();
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
}
