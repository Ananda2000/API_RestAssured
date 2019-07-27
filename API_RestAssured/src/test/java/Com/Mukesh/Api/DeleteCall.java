package Com.Mukesh.Api;

import org.testng.annotations.Test;

import Com.restap.methos.WebServieMethods;
import io.restassured.response.Response;

public class DeleteCall {
	Response responsdele;
	@Test
	
	public void deleteaRequest(String url) {
		responsdele = WebServieMethods.deletecall(url);
	}

}
