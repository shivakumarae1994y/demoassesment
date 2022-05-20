package chain_requests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutReq extends BaseClass{

	
	@Test(dependsOnMethods = "chain_requests.GetRequestWithHeaders.getReq")
	public void putReq() {
				File jsonData = new File("./src/main/resources/dataForPut");			
				 response = inpReq
							.queryParam("sysparm_fields", "sys_id,number,category,short_description")
							.contentType("application/json")
							.accept("application/xml")
							.body(jsonData)
							.put(global_sysId);
				
				
				

	}
	

}
