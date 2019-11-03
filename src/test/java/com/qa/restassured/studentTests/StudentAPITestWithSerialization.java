package com.qa.restassured.studentTests;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPITestWithSerialization {

	
	@Test
	public void createNewStudentSerialization() {
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Rest");
		
		Students student = new Students();
		student.setId(1);
		student.setFirstName("John");
		student.setLastName("Smith");
		student.setEmail("johnsmith@gmail.com");
		student.setCourses(coursesList);
		
		given().contentType(ContentType.JSON).
		body(student).
		when().post("restURL TO POST").
		then().statusCode(201).
		assertThat().body("msg", equalTo("Student Added"));
		
	}
	
	@Test
	public void getStudentRecordDeserialize() {
		
		Students student = get("url to use").as(Students.class);
		System.out.println(student.getStudentRecord());
		Assert.assertEquals(student.getSID(), 101);
	}
	
}
