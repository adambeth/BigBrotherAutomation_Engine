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

public class uddsInputSensitiveTest extends baseUSSD {
    @DataProvider(name = "ussdSensitiveTextData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "AskForInput/SensitiveText";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "nameone"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "nametwo"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "namethree"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "namefour"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message, "namefive"},


        };
    }


    @Test(dataProvider = "ussdSensitiveTextData")
    public void askForInputTest(String msisdn, String sessioID, String network, String type, String msg,String name){
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.askForInputSensitiveUSSD(msisdn,sessioID,network,type,msg);
        payLoad.setMsg(name);
        given()
                .contentType(ContentType.XML)
                .log().all()
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .assertThat()
            .body("ussd.msg", equalTo("Welcome " + name))
                .statusCode(200);


    }


}
