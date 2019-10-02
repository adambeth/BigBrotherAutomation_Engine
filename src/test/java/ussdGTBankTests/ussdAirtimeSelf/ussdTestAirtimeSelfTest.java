package ussdGTBankTests.ussdAirtimeSelf;

import baseTest.baseUSSD;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestLibaryUSSD.ussd;
import testUtilities.EndPoints.testEndpoints;
import testUtilities.ussd.createUSSDData;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ussdTestAirtimeSelfTest extends baseUSSD {

    @DataProvider(name = "createUSSDTestData", parallel = true)
    public Object[] createUSSDTestData() {

        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","1","1000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","1","2000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","1","3000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","1","4000"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", "*737#","1","5000"},

        };
    }

    @Test(priority=1, dataProvider = "createUSSDTestData" )
    public void startSession(String msisdn, String sessionID, String network, String type,String msg, String msgOptionOne,
                             String msgAmount){
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.getUSSDPayload(msisdn,sessionID,network,type,msg);
        payLoad.setMsg(msgOptionOne);
        //Step2
        given()
                .contentType(ContentType.XML)
                .log().all()
                .body(payLoad)
                .when()
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .body("ussd.msg", containsString("Please enter amount"))
                .body("ussd.type", equalTo("2"))
                .statusCode(200);


        //Step 3
        payLoad.setMsg(msgAmount);

        given()
                .contentType(ContentType.XML)
                .log().all()
                .body(payLoad)
                .post(testEndpoints.USSD)
                .then()
                .log().all()
                .assertThat()
                .body("ussd.type", equalTo("3"))
                .statusCode(200);

    }



}

