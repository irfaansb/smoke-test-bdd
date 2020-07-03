package com.bdd.smoke.test.steps;

import com.jayway.restassured.response.Response;
import org.apache.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.*;

public class StepDefinitionBase {

    static final Map<String,String> DEFAULT_HEADERS;

    static {
        DEFAULT_HEADERS = new HashMap<>();
        DEFAULT_HEADERS.put(HttpHeaders.CONTENT_TYPE, "application/json");
    }

    protected transient Response response;

    public StepDefinitionBase() {
        requestSpecification = given()
                .urlEncodingEnabled(false).log().all();
    }

    protected void makeGetCall(String url, Map<String,String> headers, String body) {
        response = (Response) given().urlEncodingEnabled(false).log().all()
                .headers(headers)
                .get(url);
    }


    protected void makePostCallWithJson(String url, Map<String,String> headers, Object body ) {
        response = (Response) requestSpecification
                .headers(headers)
                .body(body)
                .when()
                .post(url);
    }

    protected void makePutCallWithJson(String url, Map<String,String> headers, Object body ) {
        response = requestSpecification
                .headers(headers)
                .body(body)
                .put(url);
    }

    protected void makeDeleteCallWithJson(String url, Map<String,String> headers, Object body ) {
        response = (Response) requestSpecification
                .headers(headers)
                .delete(url);
    }
}