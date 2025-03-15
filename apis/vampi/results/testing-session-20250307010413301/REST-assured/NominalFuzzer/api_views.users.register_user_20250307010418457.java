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
@Order(776)
public class api_views.users.register_user_20250307010418457{

String baseURL ="http://localhost:5001";

	private void test0() throws JSONException{
		//OPERATION 0
		//Parameter initialization
		JSONObject request0_request_body = new JSONObject();
		Object request0_request_body_username = "deadeyes facing GGP ";
		request0_request_body.put("username" , request0_request_body_username);
		Object request0_request_body_password = "8HNG4xoz";
		request0_request_body.put("password" , request0_request_body_password);
		Object request0_request_body_email = "xesumkxs@live.com";
		request0_request_body.put("email" , request0_request_body_email);
		//Build request
 		RequestSpecification request0 = RestAssured.given();
		request0.contentType(ContentType.JSON).body(request0_request_body.toString());
		//Build Response
		Response response0 = request0.when().post(baseURL+"/users/v1/register");
		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_api_views.users.register_user_20250307010418457()  throws JSONException{
		test0();
	}
}
