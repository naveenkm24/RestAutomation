package com.qa.rest.assure.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.rest.testing.TestBase.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Employee_Record_TC002 extends BaseTest {
	
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	void getEmployeeData() throws InterruptedException {
		logger.info("******* Started Test Case Get Employee Record *******");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/"+empID);
		
		Thread.sleep(3);
	}
	
	@Test
	void checkResponseBody() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empID), true);
	}
	
	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkReponseTime() {
		long responseTime = response.getTime();
		Assert.assertTrue(responseTime < 6000);
	}
	
	@Test
	void checkContentType() {
		String contentType = response.getContentType();
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

}
