package ussdMenuTests;

import baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestLibaryUSSD.ussd;
import testUtilities.EndPoints.testEndpoints;
import testUtilities.ussd.createUSSDData;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class ussdMenuWithKeyWordsTestOptionsOne extends baseUSSD {


    @DataProvider(name = "ussdMenuWithKeyWords", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "menuWithKeyWords";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "one"},
                  {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "hi"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "hello"},



        };
    }

    @Test(dataProvider = "ussdMenuWithKeyWords")
    public static void testUsingKeyWordsMenuItemOne(String msisdn, String sessionID, String network, String type, String msg, String key1) {

        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.simpleMenuUSSD(msisdn, sessionID, network, type, msg);
        payLoad.setMsg(key1);

        given()
                .contentType(ContentType.XML)
                .log().all()
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .statusCode(200);
    }


}
