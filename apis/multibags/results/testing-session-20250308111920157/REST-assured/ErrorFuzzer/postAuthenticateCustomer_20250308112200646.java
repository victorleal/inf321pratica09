package ErrorFuzzer;

import static io.restassured.RestAssured.*;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.json.*;
import org.junit.jupiter.api.*;
//import org.junit.runners.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Order(635)
public class postAuthenticateCustomer_20250308112200646{

String baseURL ="http://multibags.1dt.com.br/";

	private void test0() throws JSONException{
		//OPERATION 0
		//Parameter initialization
		Object request0_query_tablet = null;
		Object request0_query_normal = null;
		JSONObject request0_request_body = new JSONObject();
		Object request0_request_body_username = "otoniel.isidoro@gmail.com";
		request0_request_body.put("username" , request0_request_body_username);
		Object request0_request_body_password = -3.4348017E37;
		request0_request_body.put("password" , request0_request_body_password);
		Object request0_query_mobile = null;
		Object request0_query_devicePlatform = null;
		//Build request
 		RequestSpecification request0 = RestAssured.given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvdG9uaWVsLmlzaWRvcm9AZ21haWwuY29tIiwiYXVkIjoidW5rbm93biIsImV4cCI6MTc0MjA0ODM2MCwiaWF0IjoxNzQxNDQzNTYwfQ.CGf8bJyhXsPNTF1P9yljQ9vIE7SsZN6yDESc9_LoF5EqtpJaSfNu34nfXtPHiojlCoPVfaXt08Dk8zHNhKevKQ");
		request0.queryParam("tablet" , request0_query_tablet);
		request0.queryParam("normal" , request0_query_normal);
		request0.queryParam("mobile" , request0_query_mobile);
		request0.queryParam("devicePlatform" , request0_query_devicePlatform);
		request0.contentType(ContentType.JSON).body(request0_request_body.toString());
		//Build Response
		Response response0 = request0.when().post(baseURL+"/api/v1/customer/login");
		String response0_response_body = response0.getBody().asString();

		Assertions.assertFalse(response0.getStatusCode()<=299,"StatusCode 2xx: The test sequence was not executed successfully.");
		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_postAuthenticateCustomer_20250308112200646()  throws JSONException{
		test0();
	}
}
