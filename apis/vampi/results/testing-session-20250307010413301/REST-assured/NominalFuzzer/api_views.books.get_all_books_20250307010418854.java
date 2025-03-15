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
@Order(853)
public class api_views.books.get_all_books_20250307010418854{

String baseURL ="http://localhost:5001";

	private void test0() throws JSONException{
		//OPERATION 0
		//Build request
 		RequestSpecification request0 = RestAssured.given();
		//Build Response
		Response response0 = request0.when().get(baseURL+"/books/v1");
		Assertions.assertFalse(response0.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
	}
	@Test
	public void test_api_views.books.get_all_books_20250307010418854()  throws JSONException{
		test0();
	}
}
