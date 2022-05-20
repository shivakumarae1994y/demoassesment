package day4;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutReq {

	
	@Test
	public void postReq() {
		
		       
		//we have to add this only in the case of validational errors
		RestAssured.useRelaxedHTTPSValidation();
		
		//CLassName obj = new ClassName();
		
		        //Mandatory code to Get request
				// we need to set our end point// server + port + resources
				RestAssured.baseURI = "https://dev61032.service-now.com/api/now/table/incident";
				File jsonData = new File("./src/main/resources/dataForPut");
				
				Response response = RestAssured.given()
							.auth()
							.basic("admin", "Henz@786")
							.queryParam("sysparm_fields", "sys_id,number,category,short_description")
							.contentType("application/json")
							.accept("application/xml")
							.body(jsonData)
							.put("5f26f2761b5f05107df6ed3abc4bcb8d");
				
				
				response.prettyPrint();
				
				String num = response.xmlPath().get("response.result.number");
				System.out.println("My updated no : "+num);

	}
	

}
