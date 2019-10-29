package com.qa.rest.assure.Tests;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.rest.testing.TestBase.BaseTest;
import com.qa.rest.utilities.Utilities;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Employee_Record_TC003 extends BaseTest{
	
	RequestSpecification httpRequest;
	Response response;
	
	String empName = Utilities.empName();
	String empSalary = Utilities.empSal();
	String empAge = Utilities.empAge();
	
	@BeforeClass
	void CreateEmployee() throws InterruptedException {
		
		logger.info("********** Starting Post New Employee Test Case **********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		//JSON Object to add our key-value pairs in POST method
		JSONObject requestParameters = new JSONObject();
		requestParameters.put("name", empName);
		requestParameters.put("salary", empSalary);
		requestParameters.put("age", empAge);
		
		//Adding a header stating request body is json
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParameters.toJSONString());
		
		response = httpRequest.request(Method.POST, "/create");
		
		Thread.sleep(5);
	}
	
	@Test
	void checkResponseBody() {
		
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains(empName), "Employee Name is not matching/present");
		Assert.assertTrue(responseBody.contains(empSalary), "Employee Salaray is not matching/present");
		Assert.assertTrue(responseBody.contains(empAge), "Employee Age is not matching/present");
	}
	
	@Test
	void checkStatusCode() {
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkStatusLine() {
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType() {
		
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
}
