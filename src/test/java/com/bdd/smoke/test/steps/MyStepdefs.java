package com.bdd.smoke.test.steps;

import com.bdd.smoke.test.dto.Category;
import com.bdd.smoke.test.utils.ConfigFileReader;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.bdd.smoke.test.utils.ApiUtil;
import org.junit.Assert;

import java.util.Map;

import static com.bdd.smoke.test.utils.ConstantsUtil.GET_METHOD;
import static com.bdd.smoke.test.utils.ConstantsUtil.GET_URL;


public class MyStepdefs extends StepDefinitionBase{

    private final transient ApiUtil util = new ApiUtil();
    ConfigFileReader configFileReader = new ConfigFileReader();

    private void submitRequest(String method, String endPoint, String body) {
        performHttpMethod(method, endPoint, body);
    }

    private void performHttpMethod(String method, String url, String body) {
        Map<String, String> headers = ApiUtil.getHeaders();

        switch (method) {
            case "get":
       //         makeGetCall(url,headers,body);
                break;
            case "post":
                makePostCallWithJson(url, headers, util.getRequestWithNewValueToTheField(body));
                break;
            case "delete":
                makeDeleteCallWithJson(url, headers, body);
                break;
            case "put":
                makePutCallWithJson(url, headers, util.getRequestWithNewValueToTheField( body));
                break;
            case "patch":
                makePatchCallWithJson(url, headers, body);
                break;
            default:
                makePostCallWithJson(url, headers, body);
                break;
        }
    }


    @Given("^API is up and running$")
    public void apiIsIpAndRunning() {
        System.out.println("Api is up and running");
    }


    @Then("^Validate Response body$")
    public void validateResponseBody() {
    }

    @When("^I validate Response code\"([^\"]*)\"$")
    public void iValidateResponseCode(String ID) throws Throwable {
        String GET_URL = configFileReader.getUrl("GET_URL");
        String FINAL_URL = GET_URL+ID;
        Map<String, String> headers = ApiUtil.getHeaders();


        Response response = makeGetCall(FINAL_URL,headers);
        System.out.println(response);
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getStatusCode());
     //   Example example = response.as(Example.class)




      //  Assert.assertEquals(response.body().);
/*        Response response = RestAssured.given()
                .headers(headers)
            //    .port()
                .get("https://petstore.swagger.io/v2/pet/");*/

    //    System.out.println(response.getStatusCode());


    }


}
