package day4;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest {

	
	@Test
	public void deleteReq() {
		
		       
		//we have to add this only in the case of validational errors
		RestAssured.useRelaxedHTTPSValidation();
		
		//CLassName obj = new ClassName();
		
		        //Mandatory code to Get request
				// we need to set our end point
		                               // server + port + resources
				RestAssured.baseURI = "https://dev61032.service-now.com/api/now/table/incident";
				
				//we nee to give our authentication
				
				RestAssured.authentication = RestAssured.basic("admin", "Henz@786");
				
				//im going to hit the send request with my GET request type
				
				Response response = RestAssured.delete("00b226721b1f05107df6ed3abc4bcbb6");
				
				response.prettyPrint();
				System.out.println("Status code verification : "+response.statusCode());

	}
	

}
