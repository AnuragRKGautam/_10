package utils;

import configuration.constants;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;

public class RestAssuredUtils {
    static constants cons = constants.getInstance();
public static JsonPath JsonReadFromExistingFile(String FILE_NAME){
    JsonPath jasonPath=new JsonPath(new File(FILE_NAME));
    return jasonPath;
}


    public static Response getResponse(String uri){
        Response response = RestAssured
                .request(Method.GET,
                        uri + cons.WEATHER_API_APP_KEY);
        Assert.assertEquals(response.statusCode(),200);
        return response;
    }

}
