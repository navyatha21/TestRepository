package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class StudentDeleteTest {
	

	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
		
	}
	
	@Test
	public void deleteStudent() {
		 given().
		when().
		delete("/101").prettyPeek();
	}

}
