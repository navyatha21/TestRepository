package com.students.tests;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class StudentPatchTest {


	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	}
	
	@Test
	public void createNewStudent() {
		
		List<String> courses = new ArrayList<String>();
		courses.add("Maths");
		courses.add("Physics");
		courses.add("Chemistry");
		
		Student st1 = new Student();
		st1.setFirstName("ABC");
		st1.setLastName("M");
		st1.setEmail("abc@gmail.com");
		st1.setProgramme("MPC");
		st1.setCourses(courses);
		
		/*given().
		contentType(ContentType.JSON).
		when().
		body(st1).
		post().then().
		statusCode(201);
		*/
		
		given().
		contentType(ContentType.JSON).
		when().
		body(st1).
		patch("/101").prettyPeek();
		
	}
}
