package chain_requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest extends BaseClass {

	
	@Test(dependsOnMethods = "chain_requests.PutReq.putReq")
	public void deleteReq() {
		
		      
				 response = inpReq 
						.delete(global_sysId);
				
				
	}
	

}
