package day4;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestWithBodyData {

	
	@Test
	public void postReq() {
		
		       
		//we have to add this only in the case of validational errors
		RestAssured.useRelaxedHTTPSValidation();
		
		//CLassName obj = new ClassName();
		
		        //Mandatory code to Get request
				// we need to set our end point// server + port + resources
				RestAssured.baseURI = "https://dev61032.service-now.com/api/now/table/incident";
				
				//we nee to give our authentication
				RestAssured.authentication = RestAssured.basic("admin", "Henz@786");
				
				File jsonData = new File("./src/main/resources/data");
				//im going to hit the send request with my GET request type
				
				Response response = RestAssured.given()
						.queryParam("sysparm_fields","sys_id,number,category,short_description")
						.contentType(ContentType.JSON)// mandatory for both post and put
						.body(jsonData)
						.post();
				
				response.prettyPrint();	

	}
	

}
