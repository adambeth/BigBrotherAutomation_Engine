/**
 * This class is to to test all the permutations of the OPTION 2 of the USSD String
 * Author: Adam Bethlehem
 */

package ussdGTBankTests.AirtimeOthersOptionTwo;

import baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestLibaryUSSD.ussd;
import testUtilities.EndPoints.testEndpoints;
import testUtilities.ussd.createUSSDData;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ussdAirtimeOthersTest extends baseUSSD {


    @DataProvider(name = "ussdAirtimeOthersTestData", parallel = true)
    public Object[] createUSSDTestData() {

        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","2","0000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","2","0000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","2","0000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","2","0000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","2","0000"},

        };
    }

    @Test(dataProvider = "ussdAirtimeOthersTestData")
    public void startSession(String msisdn, String sessionID, String network, String type, String msg, String msgAirtimeOthers,
                             String msgAmount) {
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.getUSSDPayload(msisdn, sessionID, network, type, msg);
        payLoad.setMsg(msgAirtimeOthers);
        given()
                .contentType(ContentType.XML)
                .log().all()
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("ussd.msg", containsString("Please enter amount"))
                .body("ussd.type", equalTo("2"))
                .body("ussd.msisdn", equalTo(payLoad.getMsisdn()));


        payLoad.setMsg(msgAmount);
        given()
                .contentType(ContentType.XML)
                .log().all()
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .statusCode(200)
                .body("ussd.msg", containsString("Please enter 3rd party mobile number:"))
                .body("ussd.type", equalTo("2"));

        payLoad.setMsg(payLoad.getMsisdn());
        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .log().all()
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("ussd.msisdn", equalTo(payLoad.getMsisdn()))
                .body("ussd.sessionId", equalTo(payLoad.getSessionid()))
                .body("ussd.msg", equalTo("vtu/GTBank_Airtime:step38"))
                .body("ussd.type", equalTo("5"));


    }


}
