/* The testDataFactory class is used to wrap data from a json datasource in order to use in our data driven tests.
*  The class is robust and should be updated as soon as another datasource (.json) file is added.
*  This is a once of step as any test can consume the datafactory in order to use data from any given datasource.
*
*  Confluence link:
*
* Author: Juan-Claude Botha
*/

package testUtilities.dataBuilders;

import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;


public class testDataFactory
{

    // get entire json object
    public static JSONObject vendorObject() throws IOException, ParseException {
        String vendorJsonFile = ("user.dir") + "/src/main/java/testUtilities/dataBuilders/datasource.json";

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(vendorJsonFile);
        JSONObject vendorJsonData = (JSONObject) parser.parse(reader);

        return vendorJsonData;
    }

    // get json field
    public static String getTransaction(String testsuite, String testscenario, String testfield) throws IOException, ParseException {

        String vendorJsonFile = ("user.dir") + "/src/main/java/testUtilities/dataBuilders/datasource.json";

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(vendorJsonFile);
        JSONObject vendorJsonData = (JSONObject) parser.parse(reader);

        JSONObject testVendorItem = (JSONObject)vendorJsonData.get(testsuite);
        JSONObject testVendor = (JSONObject)testVendorItem.get(testscenario);
        String testVendorfield = (String) testVendor.get(testfield);

        return testVendorfield;
    }

}
