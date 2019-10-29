package com.qa.rest.assure.Tests;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.rest.testing.TestBase.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Employee_Record_TC005 extends BaseTest {

	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	void deleteEmployee() throws InterruptedException {
		
		logger.info("********* Starting Test Case Delete Employee Record *********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/employees");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//Capture First Employee ID
		String empID = jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/delete/"+empID);
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody() {
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("successfully! deleted Records"));
	}
	
	
	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@AfterClass
	void closingMessage() {
		logger.info("*********** Completed Delete Employee Record ***********");
	}
}
