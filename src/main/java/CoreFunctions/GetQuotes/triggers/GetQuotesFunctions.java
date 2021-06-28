package CoreFunctions.GetQuotes.triggers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public interface GetQuotesFunctions {
    public RequestSpecification getQuotesPayload(String field, String value) throws Exception;
    public Response getQuotes(RequestSpecification request) throws Exception;
    public RequestSpecification getQuotesPayloadWithTwoFilters(String field1, String value1,String field2, String value2) throws Exception;
    public RequestSpecification getQuotesPayloadWithThreeFilters(String field1, String value1,String field2, String value2,String field3, String value3) throws Exception;

}
