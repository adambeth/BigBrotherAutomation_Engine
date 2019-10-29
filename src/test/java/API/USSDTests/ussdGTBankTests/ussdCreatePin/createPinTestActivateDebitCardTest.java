package API.USSDTests.ussdGTBankTests.ussdCreatePin;

import API.baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.requestLibary.USSD.ussd;
import api.testUtilities.EndPoints.ussdTestEndpoints;
import api.testUtilities.ussd.createUSSDData;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class createPinTestActivateDebitCardTest extends baseUSSD {



    @DataProvider(name = "ussdCreatePinData", parallel = true)
    public Object[] createUSSDTestData() {

        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "8", "1", "000001", "0000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "8", "1", "500002", "0001"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "8", "1", "500003", "0002"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "8", "1", "500004", "0003"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "8", "1", "500004", "0004"},


        };
    }


    @Test(priority = 2, dataProvider = "ussdCreatePinData")
    public void createPinTestActivateDebitCardTest(String msisdn, String sessionID, String network, String type,
                                                   String msg, String msgCreatePin, String msgActivateDebitCard,
                                                   String msgCardNumber, String msgPin) {
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.getUSSDPayload(msisdn, sessionID, network, type, msg);
        payLoad.setMsg(msgCreatePin);

        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .log().ifValidationFails()
                .post(ussdTestEndpoints.USSD)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .assertThat()
                .body("ussd.msisdn", equalTo(payLoad.getMsisdn()))
                .body("ussd.sessionId", equalTo(payLoad.getSessionid()))
                .body("ussd.msg", containsString("Create a PIN to opt in for 737 services"))
                .body("ussd.msg", containsString("1. Active Debit Card"))
                .body("ussd.msg", containsString("2. No Debit Card"));


        payLoad.setMsg(msgActivateDebitCard);
        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .log().ifValidationFails()
                .post(ussdTestEndpoints.USSD)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .assertThat()
                .body("msg.type", equalTo("2"))
                .body("ussd.msg", equalTo("Please enter the last six digits of your GTBank debit card to continue"));


        payLoad.setMsg(msgCardNumber);
        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .log().ifValidationFails()
                .post(ussdTestEndpoints.USSD)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .body("ussd.msg", equalTo("Please enter your new four digit PIN"))
                .body("ussd.type", equalTo("2"))
                .statusCode(200);

        payLoad.setMsg(msgPin);
        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .log().ifValidationFails()
                .post(ussdTestEndpoints.USSD)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .body("ussd.msg", equalTo("Pin has been created."))
                .body("ussd.type", equalTo("3"))
                .statusCode(200);


    }


}
