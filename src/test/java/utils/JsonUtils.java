package utils;



import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;



public class JsonUtils {
    private static Response ResponseBody;
    public static void assertErrorMessagesForAPI(String jsonObjectNameFromRes, JsonPath jsonPathFromRes, String errorFileName, String expPath) throws IOException, URISyntaxException {

        JsonPath errorMessages = RestAssuredUtils.JsonReadFromExistingFile(errorFileName);

        List expectedList = errorMessages.getJsonObject(expPath);
        List actualList = jsonPathFromRes.getJsonObject(jsonObjectNameFromRes);
        Assert.assertEquals(actualList.size(), expectedList.size());

        System.out.println("Setting dateTime to null:");
        for (int i = 0; i < expectedList.size(); i++) {
            Map expected = (Map) expectedList.get(i);
            ((Map) actualList.get(i)).put("dateTime", null);
            expected.put("dateTime", null);
//            System.out.println("expectedList.get(i) = " + expectedList.get(i));
//            System.out.println("actualList.get(i) = " + actualList.get(i));

        }
        System.out.println();
        System.out.println("Asserting error messages:");
        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println("expectedList.get(i) = " + expectedList.get(i));
            System.out.println("actualList.get(i) = " + actualList.get(i));
            Assert.assertTrue(actualList.contains(expectedList.get(i)));

        }
    }


    public static void assertErrorMessagesForIngestion(String jsonpathForExpected, JsonPath ingestionResponse, String errorFileName, String pathForResponse) throws IOException, URISyntaxException {


        JsonPath errorMessages = RestAssuredUtils.JsonReadFromExistingFile(errorFileName);

        List expectedList = errorMessages.getJsonObject(jsonpathForExpected);
        System.out.println("expectedList.get(i) = " + expectedList.toString());
        List<List<List<Map>>> actualListGParent = ingestionResponse.getJsonObject(pathForResponse);
        List<List<Map>> actualListP = actualListGParent.get(0);
        List actualList = actualListP.get(0);

        Assert.assertEquals(actualList.size(), expectedList.size());
        System.out.println("actualList.get(i) = " + actualList.toString());
        System.out.println("actualList.get(i) = " + actualList.size());
        System.out.println("Setting dateTime to null:");
        for (int i = 0; i < expectedList.size(); i++) {
            Map expected = (Map) expectedList.get(i);
            ((Map) actualList.get(i)).put("dateTime", null);
            expected.put("dateTime", null);
            System.out.println("expectedList.get(i) = " + expectedList.get(i));
            System.out.println("actualList.get(i) = " + actualList.get(i));

        }

        System.out.println();
        System.out.println("Asserting error messages:");
        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println("expectedList.get(i) = " + expectedList.get(i));
            System.out.println("actualList.get(i) = " + actualList.get(i));
            Assert.assertTrue(actualList.contains(expectedList.get(i)));

        }
    }


    public static void assertErrorMessagesForIng(String jsonObjectName, JsonPath ingestionResponse, String errorFileName, String path) throws IOException, URISyntaxException {


        JsonPath errorMessages = RestAssuredUtils.JsonReadFromExistingFile(errorFileName);

        List expectedList = errorMessages.getJsonObject(jsonObjectName);
        System.out.println("expectedList.get(i) = " + expectedList.toString());
        List<List<List<Map>>> actualListGParent = ingestionResponse.getJsonObject(path);
        // List<List<Map>> actualListP = actualListGParent.get(0);
        // List actualList = actualListGParent.get(0);

        Assert.assertEquals(actualListGParent.size(), expectedList.size());
        System.out.println("actualList.get(i) = " + actualListGParent.toString());
        System.out.println("actualList.get(i) = " + actualListGParent.size());
        System.out.println("Setting dateTime to null:");
        for (int i = 0; i < expectedList.size(); i++) {
            Map expected = (Map) expectedList.get(i);
            ((Map) actualListGParent.get(i)).put("dateTime", null);
            expected.put("dateTime", null);
            System.out.println("expectedList.get(i) = " + expectedList.get(i));
            System.out.println("actualList.get(i) = " + actualListGParent.get(i));

        }

        System.out.println();
        System.out.println("Asserting error messages:");
        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println("expectedList.get(i) = " + expectedList.get(i));
            System.out.println("actualList.get(i) = " + actualListGParent.get(i));
            Assert.assertTrue(actualListGParent.contains(expectedList.get(i)));

        }
    }

    public static void assertErrorMessagesForIngHavingMsgAtChild(String jsonObjectName, JsonPath ingestionResponse, String errorFileName, String path) throws IOException, URISyntaxException {


        JsonPath errorMessages = RestAssuredUtils.JsonReadFromExistingFile(errorFileName);

        List expectedList = errorMessages.getJsonObject(jsonObjectName);
        System.out.println("expectedList.get(i) = " + expectedList.toString());
        System.out.println("actualList.get(i) = " + ingestionResponse.getJsonObject(path));
        List<Map> actualListGParent = ingestionResponse.getJsonObject(path);
        // List<List<Map>> actualListP = actualListGParent.get(0);
        // List actualList = actualListGParent.get(0);

        Assert.assertEquals(actualListGParent.size(), expectedList.size());
//        System.out.println("actualList.get(i) = " + actualListGParent.toString());
//        System.out.println("actualList.get(i) = " + actualListGParent.size());
        System.out.println("Setting dateTime to null:");
        for (int i = 0; i < expectedList.size(); i++) {
            Map expected = (Map) expectedList.get(i);
            ((Map) actualListGParent.get(i)).put("dateTime", null);
            expected.put("dateTime", null);
            System.out.println("expectedList.get(i) = " + expectedList.get(i));
            System.out.println("actualList.get(i) = " + actualListGParent.get(i));

        }

        System.out.println();
        System.out.println("Asserting error messages:");
        for (int i = 0; i < expectedList.size(); i++) {
            System.out.println("expectedList.get(i) = " + expectedList.get(i));
            System.out.println("actualList.get(i) = " + actualListGParent.get(i));
            Assert.assertTrue(actualListGParent.contains(expectedList.get(i)));

        }
    }

    public static void compare_expected_and_actual_results(Response responseBody, String outputJsonName) throws Exception {
        responseBody.prettyPrint();
//        String tempFileName = generateFile(outputJsonName, "temp");
        JsonPath jasonPath = RestAssuredUtils.JsonReadFromExistingFile(outputJsonName);

        List expectedList = jasonPath.get();
        List actualList = responseBody.jsonPath().get();

        JSONAssert.assertEquals((new JSONArray(expectedList)).toString(),
                (new JSONArray(actualList)).toString(), new JsonComparator(JSONCompareMode.LENIENT));
    }





    public static void compare_expected_and_actual(Response responseBody, String outPutFileName) throws Exception {
        JsonPath jasonPathForOutPut = RestAssuredUtils.JsonReadFromExistingFile(outPutFileName);
        System.out.println("Print outPutFileName >>>>" + outPutFileName);
        // Ignore dynamically generated data
        List<Map> actual = responseBody.jsonPath().get();
//        List<Map> actual = responseBody.jsonPath().get();
        System.out.println(actual);
        List<Map> expected = jasonPathForOutPut.get();

//        for (int i=0; i< actual.size();i++){
//            ((Map) actual.get(i)).put("uri", null);
//            ((Map) expected.get(i)).put("uri", null);
//        }

        JSONAssert.assertEquals((new JSONArray(expected)).toString(),
                (new JSONArray(actual)).toString(), new JsonComparator(JSONCompareMode.LENIENT));
    }
}
