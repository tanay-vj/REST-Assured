package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GETandPOSTexamples {
	
//	@Test
	public void test_GET() {
		baseURI = "https://reqres.in/api";
		
		given().
		get("/users?page=2").
		then().
		body("data[5].first_name",equalTo("Rashel")).
		body("data.first_name",hasItems("Rashel"));
	
	}
	
	@Test
	public void test_POST() {
		
		//Using map
//		Map<String,Object> map1 = new HashMap<String,Object>();
//		map1.put("name","Tanay");
//		map1.put("job", "SDET");
//		JSONObject request1 = new JSONObject(map1);
//		System.out.println(request1);
		
		//Without Map
		JSONObject request2 = new JSONObject();
		request2.put("name", "Tanay");
		request2.put("job", "SDE");
		System.out.println(request2);
		System.out.println("JSON String ="+request2.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request2.toJSONString()).
		when().
			post("/users").
		then().
			log().all();
		
	}

}
