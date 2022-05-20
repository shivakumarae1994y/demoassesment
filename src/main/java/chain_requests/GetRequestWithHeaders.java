package chain_requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestWithHeaders extends BaseClass {

	
	@Test
	(dependsOnMethods = 
	"chain_requests.PostRequestWithBodyData.postReq")
	public void getReq() {
						 response = inpReq
						.accept("application/xml")
						.get();			
				
	}
	

}
