package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class StudentGetTest {

	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
		
	}
	
	@Test
	public void getAllStudentInformation() {
		
		Response res = given().
		when().
		get("/list");
		
		int statusCode = given().
		when().
		get("/list").getStatusCode();
		
		System.out.println(res.body().prettyPrint());
		
		System.out.println(statusCode);
		
		given().
		when().
		get("/list").then().statusCode(200);
		
		
		}
	
	@Test
	public void getStudentInformation() {
		given().
		when().
		get("/1").prettyPrint();
		
		given().
		when().
		get("/list?programme=Financial Analysis&limit=2").prettyPrint();
		
		given().
		param("programme", "Financial Analysis").
		param("limit",2).
		when().
		get("/list").prettyPeek();
		
	}
	
	@Test
	public void logHeaderInformation() {
		given().log().headers().
		when().get("/1").then().statusCode(200);
	}
}
