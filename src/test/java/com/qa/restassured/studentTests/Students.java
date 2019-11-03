package com.qa.restassured.studentTests;

import java.util.List;

public class Students {

	public Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String program;
	
	List<String> courses;
	
	public int getSID() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	
	public List<String> getCourses() {
		return courses;
	}
	
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	public String getStudentRecord() {
		return(this.id+ " " + this.firstName + " " + this.lastName+ " " + this.email +" " + this.program + " " + this.courses);
	}
	
}
