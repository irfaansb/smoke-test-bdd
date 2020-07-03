package com.bdd.smoke.test.steps;

import com.bdd.smoke.test.utils.ConfigFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.bdd.smoke.test.utils.ApiUtil;
import org.junit.Assert;

import java.util.Map;

import static com.bdd.smoke.test.utils.ConstantsUtil.*;


public class StepDefinition extends StepDefinitionBase{

    private final transient ApiUtil util = new ApiUtil();
    ConfigFileReader configFileReader = new ConfigFileReader();

    private void submitRequest(String method, String endPoint, String body) {
        performHttpMethod(method, endPoint, body);
    }

    private void performHttpMethod(String method, String url, String body) {
        Map<String, String> headers = ApiUtil.getHeaders();

        switch (method) {
            case "get":
                makeGetCall(url,headers,body);
                break;
            case "post":
                makePostCallWithJson(url, headers, util.readJsonFile(body));
                break;
            case "delete":
                makeDeleteCallWithJson(url, headers, body);
                break;
            case "put":
                makePutCallWithJson(url, headers, util.readJsonFile( body));
                break;
        }
    }


    @Given("^API is up and running$")
    public void apiIsIpAndRunning() {
    }

    @When("^I validate Response code\"([^\"]*)\"$")
    public void iValidateResponseCode(String userName) throws Throwable {
        String GET_URL = configFileReader.getUrl("GET_URL");
        String FINAL_URL = GET_URL+userName;
        submitRequest(GET_METHOD, FINAL_URL, null);

    }

    @Then("^Validate Response code \"([^\"]*)\"$")
    public void validateResponseCode(String responseCode) throws Throwable {
        Assert.assertNotNull(response);
        Assert.assertEquals(String.valueOf(response.getStatusCode()), responseCode);
        Assert.assertNotNull(response.getBody());

    }


    @Given("^User API is up and running$")
    public void userAPIIsUpAndRunning() {
    }

    @When("^I submit a request to create an user$")
    public void iSubmitARequestToCreateAnUser() {
        String POST_USER_URL = configFileReader.getUrl("POST_USER_URL");
        submitRequest(POST_METHOD, POST_USER_URL, POST_REQUEST);
    }

    @Then("^I validate Response \"([^\"]*)\"$")
    public void iValidateResponse(String responseCode) throws Throwable {
        Assert.assertEquals(String.valueOf(response.getStatusCode()), responseCode);
        Assert.assertEquals(response.getBody().jsonPath().get("code").toString(),responseCode);
        Assert.assertNotNull(response.getBody().jsonPath().get("message"));

    }

    @When("^I submit a request to delete a user$")
    public void iSubmitARequestToDeleteAUser() {

    }

    @When("^I submit a request to delete a \"([^\"]*)\"$")
    public void iSubmitARequestToDeleteA(String user) throws Throwable {
        String deleteUserUrl = configFileReader.getUrl("DELETE_USER_URL");
        String finalURL = deleteUserUrl + user;
        submitRequest(DELETE_METHOD, finalURL, null);

    }

    @When("^I submit a request to update a \"([^\"]*)\"$")
    public void iSubmitARequestToUpdateA(String user) throws Throwable {
        String putUserUrl = configFileReader.getUrl("PUT_USER_URL");
        String finalURL = putUserUrl + user;
        submitRequest(PUT_METHOD, finalURL, PUT_REQUEST);
    }
}
