package NominalFuzzer;

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
@Order(90)
public class putProductReview_20250308111941651{

String baseURL ="http://multibags.1dt.com.br/";

	private void test0() throws JSONException{
		//OPERATION 1
		//Parameter initialization
		Object request1_query_tablet = null;
		Object request1_query_normal = null;
		JSONObject request1_request_body = new JSONObject();
		Object request1_request_body_password = "aA#123456789";
		request1_request_body.put("password" , request1_request_body_password);
		Object request1_request_body_username = "otoniel.isidoro@gmail.com";
		request1_request_body.put("username" , request1_request_body_username);
		Object request1_query_mobile = null;
		Object request1_query_devicePlatform = null;
		//Build request
 		RequestSpecification request1 = RestAssured.given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvdG9uaWVsLmlzaWRvcm9AZ21haWwuY29tIiwiYXVkIjoidW5rbm93biIsImV4cCI6MTc0MjA0ODM2MCwiaWF0IjoxNzQxNDQzNTYwfQ.CGf8bJyhXsPNTF1P9yljQ9vIE7SsZN6yDESc9_LoF5EqtpJaSfNu34nfXtPHiojlCoPVfaXt08Dk8zHNhKevKQ");
		request1.queryParam("tablet" , request1_query_tablet);
		request1.queryParam("normal" , request1_query_normal);
		request1.queryParam("mobile" , request1_query_mobile);
		request1.queryParam("devicePlatform" , request1_query_devicePlatform);
		request1.contentType(ContentType.JSON).body(request1_request_body.toString());
		//Build Response
		Response response1 = request1.when().post(baseURL+"/api/v1/customer/login");
		String response1_response_body = response1.getBody().asString();

		Assertions.assertTrue(response1.getStatusCode()<=299,"StatusCode not 2xx for previous operation.");
		//OPERATION 0
		//Parameter initialization
		Object request0_path_reviewId = 65;
		Object request0_path_productId = 6;
		JSONObject request0_request_body = new JSONObject();
		Object request0_request_body_date = "2025-03-04";
		request0_request_body.put("date" , request0_request_body_date);
		Object request0_request_body_productId = null;
		request0_request_body.put("productId" , request0_request_body_productId);
		Object request0_request_body_customerId = request1_unknown_id;
		request0_request_body.put("customerId" , request0_request_body_customerId);
		Object request0_request_body_rating = 4;
		request0_request_body.put("rating" , request0_request_body_rating);
		Object request0_request_body_description = "This is a good product";
		request0_request_body.put("description" , request0_request_body_description);
		Object request0_request_body_language = null;
		request0_request_body.put("language" , request0_request_body_language);
		//Build request
 		RequestSpecification request0 = RestAssured.given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvdG9uaWVsLmlzaWRvcm9AZ21haWwuY29tIiwiYXVkIjoidW5rbm93biIsImV4cCI6MTc0MjA0ODM2MCwiaWF0IjoxNzQxNDQzNTYwfQ.CGf8bJyhXsPNTF1P9yljQ9vIE7SsZN6yDESc9_LoF5EqtpJaSfNu34nfXtPHiojlCoPVfaXt08Dk8zHNhKevKQ");
		request0.pathParam("reviewId" , request0_path_reviewId);
		request0.pathParam("productId" , request0_path_productId);
		request0.contentType(ContentType.JSON).body(request0_request_body.toString());
		//Build Response
		Response response0 = request0.when().put(baseURL+"/api/v1/auth/products/{productId}/reviews/{reviewId}");
		String response0_response_body = response0.getBody().asString();

		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_putProductReview_20250308111941651()  throws JSONException{
		test0();
	}
}
