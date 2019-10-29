package API.USSDTests.inputTextTests;

import baseTestUtils.baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.requestLibary.USSD.ussdGeneric;
import api.testUtilities.EndPoints.ussdTestEndpoints;
import api.testUtilities.ussd.ussdGenericProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class inputRedirectTest extends baseUSSD {



    @DataProvider(name = "ussdInputRedirectData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "AskForInput/Redirect_test";
        String respType = "2";
        String respMsg = "Enter your name";
        String name = "Adam";
        return new String[][]{

                {message,"1","1",respType,respMsg,name},
                {message,"1","1",respType,respMsg,name},
                {message,"1","1",respType,respMsg,name},
                {message,"1","1",respType,respMsg,name},
                {message,"1","1",respType,respMsg,name},




        };
    }
    //Step2
    @Test(dataProvider = "ussdInputRedirectData")
    public void askForInputRedirectTest(String message, String type, String network, String respType, String respMsg, String name) {
        //Step 2 variable
        String msg2 = "You have been redirected";
        String type2 = "3"
;


        ussdGenericProvider x = new ussdGenericProvider();
        ussdGeneric payLoad;
        payLoad = x.getGenericUSSD(message,type,network,respType,respMsg);
        payLoad.setMsg(name);
        given()
                .contentType(ContentType.XML)
                .log().ifValidationFails()
                .body(payLoad)
                .when()
                .post(ussdTestEndpoints.USSD)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .body("ussd.msg", equalTo(msg2))
                .body("ussd.type",equalTo(type2))
                .statusCode(200);
    }
}
