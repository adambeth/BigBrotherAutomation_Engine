package pwmTest;

import baseTest.testConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestLibary.PWM.pwmConfirmationPOJO;

import static io.restassured.RestAssured.given;

public class ConfirmTest extends testConfig {


    @DataProvider(name = "ConfirmData", parallel = false)
    public Object[] createUSSDTestData() {

        return new String[][]{

                {
                        "sdfdsdgsdgf", "A5BD651282F", "10000", "84238385A257E16A", "0000", "2019-08-28T01:37:55.359+02:00"}
        };
    }

    @Test(dataProvider = "ConfirmData")
    public void confirmTest(String clientTnxRef, String raasTnxRef, String reserveAmount, String reserveFundTxnRef, String responseCode, String timestamp) {

        pwmConfirmationPOJO payload = new pwmConfirmationPOJO(reserveFundTxnRef,clientTnxRef,reserveAmount,raasTnxRef,responseCode,timestamp);

        given()
                .spec(PWM_Confirmation_RequestSpec)
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
                .when()
                .post()
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(202);




    }

}

