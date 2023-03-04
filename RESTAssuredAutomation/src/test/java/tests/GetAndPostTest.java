package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAndPostTest {
//	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[5].email", equalTo("rachel.howell@reqres.in")).
			body("data.first_name", hasItems("Tobias","George")).
			log().all();
	}
	
	@Test
	public void testPost() {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "morpheus");
//		map.put("job", "leader");
		
//		System.out.println(map);
		
		JSONObject req = new JSONObject(map);
		req.put("name", "morpheus");
		req.put("job", "leader");
		System.out.println(req);
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
}
