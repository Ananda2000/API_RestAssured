package Com.rrestapi.webservice.methos;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WebservicesMethods {
	
	// method of get call
	@BeforeMethod
	public void beforemethod() {
	String url="https://reqres.in/api/users";
	}
	@Test
	public static Response get(String url) {
		
		RequestSpecification requestspecification = RestAssured.given();
	requestspecification.contentType(ContentType.JSON);
	
		Response response = requestspecification.get(url);
		System.out.println("The response is :"+ response);
		return response;
		
	}
	
	public  Response deletecall(String url)	{
		
		RequestSpecification requestspecdele = RestAssured.given();
		//RequestSpecification.contentType(ContentType.JSON);
		requestspecdele.contentType(ContentType.JSON);
		Response response = requestspecdele.get(url);
		return response;
		
	}

}
