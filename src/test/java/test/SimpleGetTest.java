package test;

import configuration.constants;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import utils.RestAssuredUtils;
import utils.fileUtils;
import static utils.RestAssuredUtils.getResponse;


//https://openweathermap.org/api

public class SimpleGetTest{
    constants cons = constants.getInstance();
   @Test
    public  void test(){
       Response response  = getResponse(cons.OWM_WEATHER_2_5+"?q=London"+ cons.WEATHER_API_APP_KEY);
//        System.out.println(response.path("coord"));
//        System.out.println(response.path("coord"));
if(response.getBody()!=null)
{
    System.out.println(response.getStatusCode());
    System.out.println(response.prettyPrint());
    JsonPath jsonPath = new JsonPath(response.asString());
    System.out.println(jsonPath.prettyPrint());
    System.out.println(jsonPath.get("main.temp").toString());

}

    }

//@Test
    public void readingFromFixedJson()  {
//        JSONObject jsonObject = fileUtils.readJson();
//        JSONObject jsonObject= fileUtils.readJson("/Users/harry/git/DemoChrome/src/test/resources/test.json");
//        JSONObject jsonObject= fileUtils.returnJsonObject("./src/test/resources/data/history.city.list.min.json");
        JSONArray jsonArray = fileUtils.returnJsonArray("./src/test/resources/data/history.city.list.min.json");
//   for (int i =0 ;i<jsonArray.size();i++)
//   {
//       System.out.println("This is execution Number: "+ i +"  "+((JSONObject) jsonArray.get(i)).get("city"));
//   }
    JsonPath jsonPath =  new JsonPath(jsonArray.toJSONString());
    System.out.println(jsonPath.get("country").toString());




    }
}