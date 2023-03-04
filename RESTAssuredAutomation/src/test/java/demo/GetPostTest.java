package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetPostTest {
//	@Test
	public void getTest() {
		baseURI = "https://reqres.in/api/";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			log().all();
	}
	
	@Test
	public void postTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject req = new JSONObject(map);
		req.put("name", "morpheus");
		req.put("job", "leader");
		System.out.println(req);
		
		baseURI = "https://reqres.in/api/";
		
		given().
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