package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class fileUtils {

/*   public static JSONObject readJson(){
    JSONObject jsonObject = null;
    JSONParser parser = new JSONParser();
    try (Reader reader = new FileReader("/Users/harry/git/DemoChrome/src/test/resources/test.json")){
         jsonObject = (JSONObject) parser.parse(reader);
    } catch (ParseException | IOException e) {
        e.printStackTrace();
    }
    return jsonObject;
}*/

    public static JSONObject readJson(){
    return returnJsonObject("/Users/harry/git/DemoChrome/src/test/resources/test.json");
    }

    public static JSONObject returnJsonObject(String path){
        JSONObject jsonObject = null;
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(path)){
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    public static JSONArray returnJsonArray(String path){
        JSONArray jsonArray = null;
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(path)){
            jsonArray = (JSONArray) parser.parse(reader);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

}
