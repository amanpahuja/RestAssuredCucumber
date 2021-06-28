package CoreComponents.Common;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class AssertUtil {

    public synchronized static void validateJsonSchema(Response response, String jsonFilePath){
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonFilePath));
    }
}
