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
@Order(2013)
public class api_views.users.update_password_20250307010425716{

String baseURL ="http://localhost:5001";

	private void test0() throws JSONException{
		//OPERATION 0
		//Parameter initialization
		JSONObject request0_request_body = new JSONObject();
		Object request0_request_body_password = ":4kx8SKsq!WiJX1f";
		request0_request_body.put("password" , request0_request_body_password);
		Object request0_path_username = "scends";
		//Build request
 		RequestSpecification request0 = RestAssured.given();
		request0.pathParam("username" , request0_path_username);
		request0.contentType(ContentType.JSON).body(request0_request_body.toString());
		//Build Response
		Response response0 = request0.when().put(baseURL+"/users/v1/{username}/password");
		String response0_response_body = response0.getBody().asString();

		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_api_views.users.update_password_20250307010425716()  throws JSONException{
		test0();
	}
}
