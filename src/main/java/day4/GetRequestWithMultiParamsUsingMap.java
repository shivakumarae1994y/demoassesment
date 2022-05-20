package day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestWithMultiParamsUsingMap {

	
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
				
				//im going to get the sys_id,category and number in json forman using Get request
				//have to get  the incident only with the category as software
				Map<String, String> mp = new HashMap<String, String>();//()
				mp.put("sysparm_fields","sys_id,number,category");//{sysparm_fields=sys_id,number,category}
				mp.put("category", "software");//{sysparm_fields=sys_id,number,category,category=software}
				
				
				Response response = RestAssured.given()
												.queryParams(mp)
												.contentType(ContentType.JSON)
												.accept(ContentType.JSON)
												.when()
												.get();
				//response.prettyPrint();
				//List<String> allNumber = response.jsonPath().getList("result.number");
	
				//System.out.println(allNumber);
				
				
				List<Object> listOfNums = response.jsonPath().getList("result.number");
				List<Object> listOfSysId = response.jsonPath().getList("result.sys_id");
				List<Object> listOfCat = response.jsonPath().getList("result.category");
			
				System.out.println(listOfNums);
				System.out.println(listOfSysId);
				System.out.println(listOfCat);
	}
	

}
