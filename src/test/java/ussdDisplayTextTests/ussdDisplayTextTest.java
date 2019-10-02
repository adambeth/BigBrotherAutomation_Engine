package ussdDisplayTextTests;

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

public class ussdDisplayTextTest extends baseUSSD {

    @DataProvider(name = "ussdDisplayTextData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "DisplayText/PlainText";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "a"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "b"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "c"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "d"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "e"},



        };
    }

    @Test(dataProvider = "ussdDisplayTextData")
    public void ussdSimpleMenu(String msisdn, String sessionID, String network, String type, String msg, String name) {
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.displayTextInputUSSD(msisdn, sessionID, network, type, msg);
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
                .body("ussd.type",equalTo("3"))
                .statusCode(200);

    }

}
