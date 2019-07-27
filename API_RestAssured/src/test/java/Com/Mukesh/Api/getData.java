
package Com.Mukesh.Api;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Com.RestAPI.Utils.*;
import Com.RestAPI.Utils.xlprovider;
import Com.restap.methos.WebServieMethods;
import Com.rrestapi.webservice.methos.WebservicesMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

import pojoclasses.weatherCityCodes;

public class getData {
	
	Response responses;
	
	@Test
	public void getstatuscodeandLine() {
	RequestSpecification httprequest = RestAssured.given();
	httprequest.contentType(ContentType.JSON);
	
	System.out.println("======================================= The response body===================");
	Response StringRespons = httprequest.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
	System.out.println("=========="+StringRespons.getBody().asString());
	
	int statuscode= StringRespons.getStatusCode();
	String stautsline = StringRespons.getStatusLine();
	System.out.println("The status line is :"+stautsline);
	System.out.println("The status code is :"+ statuscode);
	
	
	Assert.assertEquals(200, statuscode);
	Assert.assertEquals("HTTP/1.1 200 OK",stautsline );
	
	}
	
	@Test
	public void validateResponsebody() {
		 
		Gson gson = new GsonBuilder().create(); 
		weatherCityCodes WeatherCityCodes;
		RequestSpecification resp1 =  RestAssured.given();
		resp1.contentType(ContentType.JSON);
		Response resp11 = resp1.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		int Statuscode = resp11.getStatusCode();
		if(Statuscode == 200) {
			System.out.println("*****************successfull");
			//WeatherCityCodes = gson.fromJson(resp11.getBody().asString(), weatherCityCodes[].class);
			WeatherCityCodes = gson.fromJson(resp11.getBody().asString(), weatherCityCodes.class);
			
			 System.out.println(WeatherCityCodes.getCity());
			 System.out.println(WeatherCityCodes.getHumidity());
			 System.out.println(WeatherCityCodes.getTemperature());
			 System.out.println(WeatherCityCodes.getWeatherDescription());
			 System.out.println(WeatherCityCodes.getWindDirectionDegree());
			 System.out.println(WeatherCityCodes.getWindSpeed());
			 
			
		}
		
	//	System.out.println("The response body is:"+resp11.getBody().asString());
	}

	
	@DataProvider (name ="cities")
	public Object[][] dataproviders() throws Exception {
		
		Object[][] ta = xlprovider.getTableArray("D:/Anand/city_Info.xlsx", "Sheet1");
		return ta;
		
	}
	
	
	@DataProvider (name="postdataprovider")
	public Object[][] postdataprovider() {
		Object[][] result = new Object[1][1];
		
		result[0][0] = "{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
		//result[0][1]= 
		return result;
	}
	@Test (dataProvider="postdataprovider")
	public void postcallworking(String jsonresponse) {
		
	//	String url="https://reqres.in/api/users";
		String url = URL.fixurl +URL.EPU_postData;
		
		responses = WebServieMethods.postmethod(url, jsonresponse);
		
		System.out.println("The response code is :"+ responses.asString());
		System.out.println("The response code is :"+ responses.getStatusCode());
		
	}
}
