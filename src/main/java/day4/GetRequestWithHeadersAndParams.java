package day4;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestWithHeadersAndParams {

	
	@Test
	public void getReq() {
		
		       
		//we have to add this only in the case of validational errors
		RestAssured.useRelaxedHTTPSValidation();
		
		
		        //Mandatory code to Get request
				// we need to set our end point
		                               // server + port + resources
				RestAssured.baseURI = "https://dev61032.service-now.com/api/now/table/incident";
				
				//we nee to give our authentication
				
				RestAssured.authentication = RestAssured.basic("admin", "Henz@786");
				
				//im going to get the sys_id and number in json forman using Get request
				
				Response response = RestAssured.given()
												.queryParam("sysparm_fields", "sys_id,number")
												//.contentType(ContentType.JSON)
												.accept(ContentType.JSON)
												.when()
												.get();
				
				response.prettyPrint();
				System.out.println("The expected status code "+response.statusCode());
	
				
			
	}
	

}
