package test;

import configuration.constants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;
import utils.fileUtils;

import javax.security.auth.login.Configuration;

import static utils.RestAssuredUtils.getResponse;


//https://openweathermap.org/api

public class weather {
constants cons = constants.getInstance();
    @Test
    public void getWeatherByCity() {
        Response response = getResponse(cons.OWM_WEATHER_2_5 + "?q=London");
        if (response.getBody() != null) {
            JsonPath jsonPath = new JsonPath(response.asString());
//            System.out.println(jsonPath.get("main.temp").toString());
            response.prettyPrint();
        }
    }

    @Test
    public void getWeatherByCityAndCountry() {
        Response response = getResponse(cons.OWM_WEATHER_2_5 + "?q=London,uk");
        if (response.getBody() != null) {
            JsonPath jsonPath = new JsonPath(response.asString());
            response.prettyPrint();

        }
    }
    @Test
    public void getWeatherByCityId() {
        Response response = getResponse(cons.OWM_WEATHER_2_5 + "?id=2172797");
        if (response.getBody() != null) {
            JsonPath jsonPath = new JsonPath(response.asString());
            response.prettyPrint();

        }
    }
    @Test
    public void getWeatherByGeographicCoorindates() {
        Response response = getResponse(cons.OWM_WEATHER_2_5 + "?lat=35&lon=139");
        if (response.getBody() != null) {
            JsonPath jsonPath = new JsonPath(response.asString());
            response.prettyPrint();

        }
    }

//    api.openweathermap.org/data/2.5/weather?zip=94040,us
@Test
public void getWeatherByZipCode() {
    Response response = getResponse(cons.OWM_WEATHER_2_5 + "?zip=94040,us");
    if (response.getBody() != null) {
        JsonPath jsonPath = new JsonPath(response.asString());
        response.prettyPrint();

    }
}
//    Call current weather data for several cities
//bbox bounding box [lon-left,lat-bottom,lon-right,lat-top,zoom]
//    http://api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10

//    @Test
    public void getWeatherWithinRectagle() {
        Response response = getResponse(cons.OWM_BOX_2_5 + "/city?bbox=12,32,15,37,10");
        if (response.getBody() != null) {
            JsonPath jsonPath = new JsonPath(response.asString());
            response.prettyPrint();
        }
    }

}