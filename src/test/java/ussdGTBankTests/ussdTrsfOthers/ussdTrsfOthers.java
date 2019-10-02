package ussdGTBankTests.ussdTrsfOthers;

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

public class ussdTrsfOthers extends baseUSSD {

    @DataProvider(name = "trsfGTBankOthers", parallel = true)
    public Object[] createUSSDTestData() {

        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "5","50000","1234567890"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "5","50000","1234567890"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "5","50000","1234567890"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "5","50000","1234567890"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#", "5","50000","1234567890"},


        };
    }


    @Test(dataProvider = "trsfGTBankOthers")
    public void ussdTrsfOthersTests(String msisdn, String sessionID, String network, String type, String msg, String trnsfOthers, String amount, String nuban) {

        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.getUSSDPayload(msisdn, sessionID, network, type, msg);

        payLoad.setMsg(trnsfOthers);
        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .assertThat()
                .body("ussd.msg",equalTo("Please enter amount:"))
                .body("ussd.type", equalTo("2"))
                .statusCode(200);


        payLoad.setMsg(amount);
        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .assertThat()
                .body("ussd.msg",equalTo("Please enter recipient's NUBAN:"))
                .body("ussd.type", equalTo("2"))
                .statusCode(200);

        payLoad.setMsg(nuban);
        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .statusCode(200);

    }
}
