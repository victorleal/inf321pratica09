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
@Order(140)
public class api_views.books.add_new_book_20250307010414567{

String baseURL ="http://localhost:5001";

	private void test0() throws JSONException{
		//OPERATION 0
		//Parameter initialization
		JSONObject request0_request_body = new JSONObject();
		Object request0_request_body_book_title = "inseam";
		request0_request_body.put("book_title" , request0_request_body_book_title);
		Object request0_request_body_secret = "phallicism";
		request0_request_body.put("secret" , request0_request_body_secret);
		//Build request
 		RequestSpecification request0 = RestAssured.given();
		request0.contentType(ContentType.JSON).body(request0_request_body.toString());
		//Build Response
		Response response0 = request0.when().post(baseURL+"/books/v1");
		String response0_response_body = response0.getBody().asString();

		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_api_views.books.add_new_book_20250307010414567()  throws JSONException{
		test0();
	}
}
