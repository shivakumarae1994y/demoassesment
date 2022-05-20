package chain_requests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	static Response response = null;
	static RequestSpecification inpReq = null;
	static String  global_sysId;
	
	@BeforeMethod
	public void preCond() {
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = 
				"https://dev61032.service-now.com/api/now/table/incident";
		RestAssured.authentication = 
				RestAssured.basic("admin", "Henz@786");
		 inpReq = RestAssured.given().log().all();
	}
	
	@AfterMethod
	public void postCond() {
		response.prettyPrint();
		System.out.println
		("The expected status code "+response.statusCode());

	}

}
