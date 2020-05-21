package com.jsonpath.examples;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;


import static com.jayway.restassured.RestAssured.*;


public class JsonPathExample {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	@Test
	public void test1() {
	String itemID = given().
		queryParam("query","ipod").
		queryParam("format","json").
		queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").
		when().
		get("/search").then().extract().path("items[0].itemId");
	
	System.out.println(itemID);
		}
}
