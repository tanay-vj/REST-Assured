package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {
	@Test
	public void test_PUT() {
		
		//Without Map
		JSONObject request1 = new JSONObject();
		request1.put("name", "Tanay");
		request1.put("job", "QA");

		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request1.toJSONString()).
		when().
			put("/users/2").
		then().
			log().all();
		
	}
	
	@Test
	public void test_PATCH() {
		
		//Without Map
		JSONObject request1 = new JSONObject();
		request1.put("name", "Tanay");
		request1.put("job", "QA");

		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request1.toJSONString()).
		when().
			patch("/users/2").
		then().
			log().all();
		
	}
	
	@Test
	public void test_DELETE() {

		baseURI = "https://reqres.in/api";
		
		
		when().
			delete("/users/2").
		then().
			log().all().
		statusCode(200);
		
	}

}
