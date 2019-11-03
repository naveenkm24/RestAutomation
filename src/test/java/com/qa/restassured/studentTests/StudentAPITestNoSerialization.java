package com.qa.restassured.studentTests;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.qa.rest.testing.TestBase.BaseTest;

import io.restassured.http.ContentType;

public class StudentAPITestNoSerialization extends BaseTest{
	
	public HashMap hMap = new HashMap();
	
	@SuppressWarnings("unchecked")
	@Test
	public void createNewStudent() {
		
		logger.info("********** create student test without serialization **********");
		
		hMap.put("id", 200);
		hMap.put("firstName", "Rest");
		hMap.put("lastName", "Automation");
		hMap.put("email", "user@automation.com");
		hMap.put("program", "apiautomation");
		
		ArrayList<String> courseList = new ArrayList<String>();
		courseList.add("RestAutomation");
		courseList.add("WebServices");
		
		hMap.put("courses", courseList);
		
		given().
		contentType(ContentType.JSON).
		body(hMap).
		when().post("url").
		then().statusCode(201).
		assertThat().body("msg", equalTo("student added"));
	}
	
	@Test
	public void getStudentRecord() {
		
		logger.info("********** get student record test without serialization **********");
		
		given().
		when().get("url").
		then().statusCode(200).
		assertThat().body("id", equalTo(200));
	}

}
