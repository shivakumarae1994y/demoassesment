package chain_requests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestWithBodyData extends BaseClass {

	
	@Test
	public void postReq() {
		       		File jsonData = new File
		       				("./src/main/resources/data");	
				         response = inpReq
						.queryParam
						("sysparm_fields","sys_id,number,category,short_description")
						.contentType(ContentType.JSON)// mandatory for both post and put
						.body(jsonData)
						.post();
				 global_sysId = 
						 response.jsonPath().get("result.sys_id");
				
			

	}
	

}
