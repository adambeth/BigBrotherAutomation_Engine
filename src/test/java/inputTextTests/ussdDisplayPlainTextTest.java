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

public class ussdDisplayPlainTextTest extends baseUSSD {



    @DataProvider(name = "askForInputData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "DisplayText/InputText";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message,"name one"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message,"name 4"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message,"name three"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message,"name 2"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message,"name five"},



        };
    }

    @Test(dataProvider = "askForInputData")
    public void askForInputTest(String msisdn, String sessioID, String network, String type, String msg,String name){
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.displayTextInputUSSD(msisdn,sessioID,network,type,msg );
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
                .body("ussd.type", equalTo("3"))
                .statusCode(200);


    }
}
