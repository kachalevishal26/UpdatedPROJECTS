package demo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test1 {
//	@Test
	public void demo1() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].id", equalTo(9)).
			log().all();
	}
	
	@Test
	public void postDemo() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = new JSONObject(map);
		json.put("name", "morpheus");
		json.put("job", "leader");
		
		System.out.println(json);
		baseURI = "https://reqres.in/api";
		given().
			body(json.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
}