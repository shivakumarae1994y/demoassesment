package day4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {

	
	@Test
	public void getReq() {
		
		       
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
				
				Response response = RestAssured.given().queryParam("sysparm_fields","sys_id,number,category")
						.get();
				
			//	response.prettyPrint();	
				//Im going to check in certain index that my number is containing INC in it or not
				response.then().assertThat().body("result[0].number", Matchers.containsString("INC"));
				
				response.then().assertThat().statusCode(200);
				
				//Im having certain no and im going to check whether its inside the response body or not(no index)

				response.then().assertThat().body("result.number", Matchers.hasItem("INC0000060"));
				
				//In having the index  and also the no im going to validate is both matching the condition or not
				response.then().assertThat().body("result[0].number", Matchers.equalTo("INC0000060"));
	}
	

}
