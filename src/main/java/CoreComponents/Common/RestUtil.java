package CoreComponents.Common;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class RestUtil {
    public String url = "https://quotable.io";
    public String path = "/quotes";
    public synchronized static String getJsonPath(Response response, String key){
        String res = response.asString();
        JsonPath jsonPath = new JsonPath(res);
        return jsonPath.get(key).toString();
    }
    public synchronized static String removeSpacesAndBrackets(String data){
        String tri = data.replace("]", "").replace("[","").replaceAll("\\s","");
        return tri;
    }
    public static void verifyListContainsData(Response response,String data){
        String st = RestUtil.getJsonPath(response, "results[0].tags");
        String finalRespValues =st.replaceAll("\\s","").replace("[","").replace("]","");
        String finalInp = data.replace("!",",");
        List<String> items = Arrays.asList(finalRespValues.split("\\s*,\\s*"));
        List<String> itemsInput = Arrays.asList(finalInp.split("\\s*,\\s*"));
//        System.out.println(items.stream().anyMatch(itemsInput::contains));
        Assert.assertTrue(items.stream().anyMatch(itemsInput::contains));
    }

}
