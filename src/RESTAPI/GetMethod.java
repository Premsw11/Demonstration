package RESTAPI;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.http.Method;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.mongodb.util.JSONParseException;

public class GetMethod {
	
	public static void main(String[] args) {
		//This is method to test the RESTful Web Services
		System.out.println("started api hitting");
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response =  httpRequest.get("/hyderabad");
//		System.out.println(response.getBody().asString());
		String url = "http://restapi.demoqa.com/utilities/weather/city/jaipur";
		Response response = RestAssured.given()
				//.authentication().basic(name, password)
				.header("content-type", "application/json")
				//.body(NotesToBeAdded)
				.when()
				.post(url);
		System.out.println(response);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getContentType());
		
		Response response1 = RestAssured.given()
				.authentication().basic("hjy", "sads")
				.header("Content-Type", "application/json")
				.when()
				.delete(url);
				
		JsonParser parser = new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(response1.getBody().asString());
		System.out.println("City is "+obj.get("FaultId"));
		
	}
}
