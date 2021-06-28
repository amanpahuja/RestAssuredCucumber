package CoreFunctions.GetQuotes.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetQuotes {
    String url = "https://quotable.io";
    String path = "/quotes";
    public RequestSpecification getQuotesPayload(String field, String value) throws Exception {
        if(value.contains("!")){
            value = value.replace("!", "|");
        }
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url);
        requestSpecBuilder.addParam(field,value);
        return requestSpecBuilder.build();
    }
    public Response getQuotes(RequestSpecification requestSpec) throws Exception {
        Response response = given().
                spec(requestSpec).
                log().all().when().get(path).then().extract().response();
        return response;
    }
    public RequestSpecification getQuotesPayloadWithTwoFilters(String field1, String value1,String field2, String value2) throws Exception {
        if(value1.contains("!")){
            value1 = value1.replace("!", "|");
        }
        if(value2.contains("!")){
            value2 = value2.replace("!", "|");
        }
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url);
        requestSpecBuilder.addParam(field1,value1);
        requestSpecBuilder.addParam(field2,value2);
        return requestSpecBuilder.build();
    }
    public RequestSpecification getQuotesPayloadWithThreeFilters(String field1, String value1,String field2, String value2, String field3, String value3) throws Exception {
        if(value1.contains("!")){
            value1 = value1.replace("!", "|");
        }
        if(value2.contains("!")){
            value2 = value2.replace("!", "|");
        }
        if(value3.contains("!")){
            value3 = value3.replace("!", "|");
        }
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url);
        requestSpecBuilder.addParam(field1,value1);
        requestSpecBuilder.addParam(field2,value2);
        requestSpecBuilder.addParam(field3,value3);
        return requestSpecBuilder.build();
    }
}
