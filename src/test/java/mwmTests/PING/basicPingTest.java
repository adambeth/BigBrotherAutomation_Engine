package mwmTests.PING;

import baseTest.testConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import requestLibary.MWM.mwmPingPOJO;

import static io.restassured.RestAssured.given;

public class basicPingTest extends testConfig {


    @Test
    public void basicPingTest() {
        String vendorID = "21";
        reportBuilder.logger.pass("Test pass bitches");
        mwmPingPOJO payLoad = new mwmPingPOJO(vendorID);
        given()
                .spec(MWM_Ping_RequestSpec)
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .body(payLoad)
                .post()
                .then()
                .log().ifValidationFails()
                .statusCode(200);

    }


}
