package Com.restap.methos;

import java.util.StringJoiner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WebServieMethods {

	
	public static Response postmethod(String url, String stringJsoin) {
		System.out.println("Am in post method");
		RequestSpecification requestpost = RestAssured.given().body(stringJsoin);
		requestpost.contentType(ContentType.JSON);
	Response resppost=	requestpost.post(url);
	return resppost;
		
		
	}
	
	public static Response deletecall(String url) {
		RequestSpecification requestspecdele = RestAssured.given();
		requestspecdele.contentType(ContentType.JSON);
		Response deleteresponse =requestspecdele.get(url);
		return deleteresponse;
	}
}
