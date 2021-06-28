package stepDefinitions;
import CoreComponents.Common.AssertUtil;
import CoreComponents.Common.RestUtil;
import CoreComponents.Cucumber.TestContext;
import CoreComponents.managers.CoreFunctionsManager;
import CoreFunctions.GetQuotes.triggers.GetQuotesFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class GetQuotes {
    GetQuotesFunctions getQuotesFunctions;
    CoreFunctionsManager manager;
    RequestSpecification request;
    Response response;
    public GetQuotes(TestContext testContext){
        manager = testContext.getCoreFunctionsManager();
        getQuotesFunctions = manager.getQuotesCoreFunctions.getQuotesFunctions();
    }
    @Given("User creates the getQuotes api request payload with filter as {string} with value as {string}")
    public void user_creates_the_get_quotes_api_request_payload_with_filter_as_with_value_as(String field, String value) throws Exception{
        request = getQuotesFunctions.getQuotesPayload(field,value);
    }
    @When("User sends the request")
    public void user_sends_the_request() throws Exception{
        response = getQuotesFunctions.getQuotes(request);
    }
    @Then("Verify that the status code is {int}")
    public void verify_that_the_status_code_is(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }
    @Then("Verify that the response has field {string} and value is {string}")
    public void verify_that_the_response_has_field_and_value_is(String field, String expected) {
        System.out.println("expected: "+expected);
        System.out.println("resp value: "+RestUtil.getJsonPath(response,field));
        Assert.assertEquals(expected, RestUtil.getJsonPath(response,field));
    }

    @Then("Verify the json schema for the response as {string}")
    public void verify_the_json_schema_for_the_response_as(String string) {
        AssertUtil.validateJsonSchema(response, "jsonSchema/"+string+".json");

    }
    @Then("Verify that the tags field in response has data as {string}")
    public void verify_that_the_tags_field_in_response_has_data_as(String string) {
        Assert.assertEquals(string, RestUtil.removeSpacesAndBrackets(RestUtil.getJsonPath(response,"results[0].tags")));

    }
    @Then("Verify that the tags field in response has data as either tags mentioned in {string}")
    public void verify_that_the_tags_field_in_response_has_data_as_either_tags_mentioned_in(String tags) {
        RestUtil.verifyListContainsData(response,tags);

    }
    @Then("Verify that the response has field {string} as empty list")
    public void verify_that_the_response_has_field_as_empty_list(String string) {
        String results = RestUtil.getJsonPath(response,string);
        Assert.assertEquals(results,"[]");
    }
    @Given("User creates the getQuotes api request payload with filter as {string} with value as {string} and {string} with value as {string}")
    public void user_creates_the_get_quotes_api_request_payload_with_filter_as_with_value_as_and_with_value_as(String field1, String value1, String field2, String value2) throws Exception{
        request = getQuotesFunctions.getQuotesPayloadWithTwoFilters(field1,value1,field2,value2);

    }
    @Given("User creates the getQuotes api request payload with filter as {string} with value as {string},{string} with value as {string} and {string} with value as {string}")
    public void user_creates_the_get_quotes_api_request_payload_with_filter_as_with_value_as_with_value_as_and_with_value_as(String field1, String value1, String field2, String value2, String field3, String value3)throws Exception {
        request = getQuotesFunctions.getQuotesPayloadWithThreeFilters(field1,value1,field2,value2,field3,value3);
    }
}
