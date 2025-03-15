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
@Order(397)
public class getProductReviews_20250308112053011{

String baseURL ="http://multibags.1dt.com.br/";

	private void test0() throws JSONException{
		//OPERATION 0
		//Parameter initialization
		Object request0_path_productId = null;
		//Build request
 		RequestSpecification request0 = RestAssured.given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvdG9uaWVsLmlzaWRvcm9AZ21haWwuY29tIiwiYXVkIjoidW5rbm93biIsImV4cCI6MTc0MjA0ODM2MCwiaWF0IjoxNzQxNDQzNTYwfQ.CGf8bJyhXsPNTF1P9yljQ9vIE7SsZN6yDESc9_LoF5EqtpJaSfNu34nfXtPHiojlCoPVfaXt08Dk8zHNhKevKQ");
		request0.pathParam("productId" , request0_path_productId);
		//Build Response
		Response response0 = request0.when().get(baseURL+"/api/v1/products/{productId}/reviews");
		String response0_response_body = response0.getBody().asString();

		Assertions.assertFalse(response0.getStatusCode()<=299,"StatusCode 2xx: The test sequence was not executed successfully.");
		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_getProductReviews_20250308112053011()  throws JSONException{
		test0();
	}
}
