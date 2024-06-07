package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class testsExamples {
	
	@Test
	public void test_1() {
		
//		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		//use of * and static don't require to write RestAssured. 
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		int stCode = response.getStatusCode();
		
		Assert.assertEquals(stCode, 201);
		
	}
	
	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200);
		
		given().
		get("/users?page=2").
		then().
		body("data[1].id", equalTo(8)).
		log().all();
		
	}

}
