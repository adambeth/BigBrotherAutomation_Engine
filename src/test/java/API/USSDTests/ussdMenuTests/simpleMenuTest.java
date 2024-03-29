package API.USSDTests.ussdMenuTests;

import baseTestUtils.baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.requestLibary.USSD.ussd;
import api.testUtilities.EndPoints.ussdTestEndpoints;
import api.testUtilities.ussd.createUSSDData;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class simpleMenuTest extends baseUSSD {

    @DataProvider(name = "ussdSimpleMenu", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "simpleMenu";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "1"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "2"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "1"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "2"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "1"},


        };
    }


    @Test(dataProvider = "ussdSimpleMenu")
    public void ussdSimpleMenu(String msisdn, String sessionID, String network, String type, String msg, String name) {
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.getUSSDPayloadSimpleMenu(msisdn, sessionID, network, type, msg);
        payLoad.setMsg(name);

        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .log().ifValidationFails()
                .post(ussdTestEndpoints.USSD)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .body("ussd.msg", equalTo("Hello " + name))
                .statusCode(200);

    }

}
