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
@Order(169)
public class putProductReview_20250308111957994{

String baseURL ="http://multibags.1dt.com.br/";

	private void test0() throws JSONException{
		//OPERATION 2
		//Parameter initialization
		Object request2_header_Content-Type = "application/json";
		//Build request
 		RequestSpecification request2 = RestAssured.given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvdG9uaWVsLmlzaWRvcm9AZ21haWwuY29tIiwiYXVkIjoidW5rbm93biIsImV4cCI6MTc0MjA0ODM2MCwiaWF0IjoxNzQxNDQzNTYwfQ.CGf8bJyhXsPNTF1P9yljQ9vIE7SsZN6yDESc9_LoF5EqtpJaSfNu34nfXtPHiojlCoPVfaXt08Dk8zHNhKevKQ");
		request2.header("Content-Type" , request2_header_Content-Type);
		//Build Response
		Response response2 = request2.when().get(baseURL+"/api/v1/auth/customers/profile");
		String response2_response_body = response2.getBody().asString();

		Assertions.assertTrue(response2.getStatusCode()<=299,"StatusCode not 2xx for previous operation.");
		//OPERATION 1
		//Parameter initialization
		JSONObject request1_request_body = new JSONObject();
		Object request1_request_body_date = null;
		request1_request_body.put("date" , request1_request_body_date);
		Object request1_request_body_productId = null;
		request1_request_body.put("productId" , request1_request_body_productId);
		Object request1_request_body_customerId = request2_unknown_id;
		request1_request_body.put("customerId" , request1_request_body_customerId);
		Object request1_request_body_rating = 4;
		request1_request_body.put("rating" , request1_request_body_rating);
		Object request1_request_body_description = "This is a good product";
		request1_request_body.put("description" , request1_request_body_description);
		Object request1_request_body_language = null;
		request1_request_body.put("language" , request1_request_body_language);
		Object request1_path_productId = 6;
		//Build request
 		RequestSpecification request1 = RestAssured.given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvdG9uaWVsLmlzaWRvcm9AZ21haWwuY29tIiwiYXVkIjoidW5rbm93biIsImV4cCI6MTc0MjA0ODM2MCwiaWF0IjoxNzQxNDQzNTYwfQ.CGf8bJyhXsPNTF1P9yljQ9vIE7SsZN6yDESc9_LoF5EqtpJaSfNu34nfXtPHiojlCoPVfaXt08Dk8zHNhKevKQ");
		request1.pathParam("productId" , request1_path_productId);
		request1.contentType(ContentType.JSON).body(request1_request_body.toString());
		//Build Response
		Response response1 = request1.when().post(baseURL+"/api/v1/auth/products/{productId}/reviews");
		String response1_response_body = response1.getBody().asString();

		Assertions.assertTrue(response1.getStatusCode()<=299,"StatusCode not 2xx for previous operation.");
		//OPERATION 0
		//Parameter initialization
		Object request0_path_reviewId = request1_unknown_id;
		Object request0_path_productId = 6;
		JSONObject request0_request_body = new JSONObject();
		Object request0_request_body_date = null;
		request0_request_body.put("date" , request0_request_body_date);
		Object request0_request_body_productId = 6;
		request0_request_body.put("productId" , request0_request_body_productId);
		Object request0_request_body_customerId = 500;
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
	public void test_putProductReview_20250308111957994()  throws JSONException{
		test0();
	}
}
