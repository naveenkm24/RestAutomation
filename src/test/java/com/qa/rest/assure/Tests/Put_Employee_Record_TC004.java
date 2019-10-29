package com.qa.rest.assure.Tests;

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

public class Put_Employee_Record_TC004 extends BaseTest {
	
	RequestSpecification httpRequest;
	Response response;
	
	String empName = Utilities.empName();
	String empSalary = Utilities.empSal();
	String empAge = Utilities.empAge();
			
	@BeforeClass
	void updateEmployees() throws InterruptedException {
		
		logger.info("********* Starting Put Employee Record Test *********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		//Creating a JSON Object to add our PUT parameters
		JSONObject requestParameters = new JSONObject();
		requestParameters.put("name", empName);
		requestParameters.put("salary", empSalary);
		requestParameters.put("Age", empAge);
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParameters.toJSONString());
		
		response = httpRequest.request(Method.PUT, "/update/"+empID);
		
		Thread.sleep(10000);
	}
	
	
	@Test
	void checkResponseBody() {
		
		String responseBody = response.getBody().asString();
		
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
	}
	
	@Test
	void checkStatusCode() {
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
	}
	
	@Test
	void checkStatusLine() {
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
