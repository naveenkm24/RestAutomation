package com.qa.restassure.BDDTests;

import com.qa.rest.testing.TestBase.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class BasicRestassureBDDTests extends BaseTest {

	@Test
	public void testStatusCode() {
		
		logger.info("********* verify status code using BDD approach *********");
		
		given().
		when().get("http://jsonplaceholder.typicode.com/posts/4").
		then().statusCode(200).
		log().all();  //Log all provides a detailed response output
	}
	
	@Test
	public void testSingleContent() {
		
		logger.info("********* verify single content from response using BDD approach *********");
		
		given().
		when().get("http://jsonplaceholder.typicode.com/posts").
		then().
		statusCode(200).
		body("[6].title", equalTo("magnam facilis autem"));
	}
	
	@Test
	public void testMultipleContentFromResponse() {
		
		logger.info("********* verify multiple content from response using BDD approach *********");
		
		given().
		when().get("http://jsonplaceholder.typicode.com/posts").
		then().
		statusCode(200).
		body(".title", hasItems("magnam facilis autem", "eum et est occaecati", "nesciunt quas odio",
				"eveniet quod temporibus"));
	}
	
	@Test
	public void testPassingParametersAndHeaders() {
		
		logger.info("********* verify passing parameters and headers using BDD approach *********");
		
		given().
		params("Name", "RESTSERVICE").
		header("header", "TestHeader").
		when().get("http://jsonplaceholder.typicode.com/posts").
		then().
		statusCode(200).
		log().all();
	}
}

