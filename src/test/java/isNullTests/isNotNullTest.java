package isNullTests;

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

public class isNotNullTest extends baseUSSD {

    @DataProvider(name = "isNotNullPositiveTestData", parallel = true)
    public Object[] createUSSDTestData() {
        String message ="IsNull/SimpleTestNegative";

        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},




        };
    }

    @Test(dataProvider = "isNotNullPositiveTestData")
    public static void IsNull_SimpleTest(String msisdn, String sessionID, String network, String type, String msg) {
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.getUSSDPayload(msisdn, sessionID, network, type, msg);
        payLoad.setMsg(msg);

        given()
                .contentType(ContentType.XML)
                .body(payLoad)
                .when()
                .log().all()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .assertThat()
                .body("ussd.msg",equalTo("It is not Null"))
                .body("ussd.type",equalTo("3"))
                .statusCode(200);


    }
}
