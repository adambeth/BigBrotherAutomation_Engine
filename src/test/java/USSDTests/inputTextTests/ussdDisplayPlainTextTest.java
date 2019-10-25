package USSDTests.inputTextTests;

import baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestLibary.USSD.ussdGeneric;
import testUtilities.EndPoints.ussdTestEndpoints;
import testUtilities.ussd.ussdGenericProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ussdDisplayPlainTextTest extends baseUSSD {


    @DataProvider(name = "askForInputData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "DisplayText/InputText";
        String respType = "2";
        String respMsg = "Enter your name";
        String name = "CerebroName";
        return new String[][]{


                {message, "1", "1", respType, respMsg, name},
                {message, "1", "1", respType, respMsg, name},
                {message, "1", "1", respType, respMsg, name},
                {message, "1", "1", respType, respMsg, name},
                {message, "1", "1", respType, respMsg, name},


        };
    }

    @Test(dataProvider = "askForInputData")
    public void askForInputTest(String message, String type, String network, String respType, String respMsg, String name) {
        String msg2 = "Welcome " + name;
        String type2 = "3";

        ussdGenericProvider x = new ussdGenericProvider();
        ussdGeneric payLoad;
        payLoad = x.getGenericUSSD(message, type, network, respType, respMsg);
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
                .body("ussd.type", equalTo(type2))
                .statusCode(200);


    }
}
