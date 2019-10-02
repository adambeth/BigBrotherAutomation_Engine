package inputTextTests;

import baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestLibaryUSSD.ussd;
import testUtilities.EndPoints.testEndpoints;
import testUtilities.ussd.createUSSDData;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ussdInputTextTest extends baseUSSD {

    @DataProvider(name = "ussdInputTextData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "DisplayText/PlainText";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "nameone"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "nametwo"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "namethree"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "namefour"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "namefive"},


        };
    }


    @Test(dataProvider = "ussdInputTextData")
    public void ussdInputTextTest(String msisdn, String sessionID, String network, String type, String msg, String name) {
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.getUSSDPayloadPlainText(msisdn, sessionID, network, type, msg);
        payLoad.setMsg(name);

        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .log().all()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .assertThat()
                .body("ussd.msg", equalTo("Welcome " + name))
                .statusCode(200);

    }

}