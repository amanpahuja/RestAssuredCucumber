package CoreFunctions.GetQuotes.triggers.impl;

import CoreFunctions.GetQuotes.services.GetQuotes;
import CoreFunctions.GetQuotes.triggers.GetQuotesFunctions;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetQuotesFunctionsImpl implements GetQuotesFunctions {
    GetQuotes getQuotes = new GetQuotes();
    public RequestSpecification getQuotesPayload(String field, String value) throws Exception {
        return getQuotes.getQuotesPayload(field,value);
    }
    public Response getQuotes(RequestSpecification requestSpec) throws Exception {
        return getQuotes.getQuotes(requestSpec);
    }
    public RequestSpecification getQuotesPayloadWithTwoFilters(String field1, String value1,String field2, String value2) throws Exception {

        return getQuotes.getQuotesPayloadWithTwoFilters(field1,value1,field2,value2);
    }
    public RequestSpecification getQuotesPayloadWithThreeFilters(String field1, String value1,String field2, String value2, String field3, String value3) throws Exception {

        return getQuotes.getQuotesPayloadWithThreeFilters(field1,value1,field2,value2, field3, value3);
    }

}
