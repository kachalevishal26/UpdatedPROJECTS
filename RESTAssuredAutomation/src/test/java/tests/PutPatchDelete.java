package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PutPatchDelete {
	@Test
	public void putTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject req = new JSONObject(map);
		req.put("name", "morpheus");
		req.put("job", "vishal");
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void patchTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject();
		request.put("name", "Vishal");
		request.put("job", "Test Engineer");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void deleteTest() {
		baseURI = "https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
		
	}
}