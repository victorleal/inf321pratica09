package unicamp.br.inf321;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.common.mapper.TypeRef;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.json.*;
import org.junit.jupiter.api.*;
//import org.junit.runners.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Order(41)
public class postProductReview_20250308111928818 {

    String baseURL ="http://multibags.1dt.com.br/";

    private void deleteReview(String token, Integer productId, Integer reviewId){
        RequestSpecification request1 = RestAssured.given().header("Authorization","Bearer " + token);
        request1.contentType(ContentType.JSON);
        request1.pathParam("productId" , productId);
        request1.pathParam("reviewId" , reviewId);
        Response response1 = request1.when().delete(baseURL + "api/v1/auth/products/{productId}/reviews/{reviewId}");

        if (response1.getStatusCode() == 200){
            System.out.println("Review deleted successfully.");
        }
    }

    private void test0() throws JSONException{
        // AUTENTICACAO DO USUARIO PARA OBTER O TOKEN
        JSONObject request2_request_body = new JSONObject();
        Object request2_request_body_password = "Grupo06";
        Object request2_request_body_username = "grupo06@qa.com";
        request2_request_body.put("password" , request2_request_body_password);
        request2_request_body.put("username" , request2_request_body_username);

        //Build request
        RequestSpecification request2 = RestAssured.given();
        request2.contentType(ContentType.JSON).body(request2_request_body.toString());

        //Build Response
        Response response2 = request2.post(baseURL+"api/v1/customer/login");

        // Captura o token e o customerId
        JsonPath jsonPathEvaluator = response2.jsonPath();
        String token = jsonPathEvaluator.get("token");
        Integer customerId = jsonPathEvaluator.get("id");

        Assertions.assertFalse(response2.getStatusCode()>=500,"StatusCode 5xx: The test sequence was not executed successfully.");
        Assertions.assertEquals(200, response2.getStatusCode(),"User logged in successfully.");
        // AUTENTICACAO DO USUARIO PARA OBTER O TOKEN

        //OPERATION 0
        //Parameter initialization
        JSONObject request0_request_body = new JSONObject();
        Object request0_request_body_productId = 10;
        Object request0_request_body_date = "2025-03-08";
        Object request0_request_body_rating = 4;
        Object request0_request_body_description = "This is a good product";
        request0_request_body.put("date" , request0_request_body_date);
        request0_request_body.put("productId" , request0_request_body_productId);
        request0_request_body.put("customerId" , customerId);
        request0_request_body.put("rating" , request0_request_body_rating);
        request0_request_body.put("description" , request0_request_body_description);

        //Build request
        RequestSpecification request0 = RestAssured.given().header("Authorization","Bearer " + token);
        request0.pathParam("productId" , request0_request_body_productId);
        request0.contentType(ContentType.JSON).body(request0_request_body.toString());

        //Build Response
        Response response0 = request0.when().post(baseURL+"api/v1/auth/products/{productId}/reviews");

        Assertions.assertEquals(201, response0.getStatusCode(),"StatusCode should be 201: Review created successfully.");

        Assertions.assertFalse(response0.getStatusCode() >= 400,"StatusCode 4xx: There's an error on the request.");
        Assertions.assertFalse(response0.getStatusCode() >= 500,"StatusCode 5xx: The test sequence was not executed successfully.");

        // Delete review to avoid problems when calling the test again
        // The API does not allow a customer to send a review for the same product more than once
        // So we delete the review after the test, and we can run it again to the same product and customer
        jsonPathEvaluator = response0.jsonPath();
        Integer reviewId = jsonPathEvaluator.get("id");
        deleteReview(token, (Integer) request0_request_body_productId, reviewId);
    }

    @Test
    public void test_postProductReview_20250308111928818()  throws JSONException{
        test0();
    }
}
