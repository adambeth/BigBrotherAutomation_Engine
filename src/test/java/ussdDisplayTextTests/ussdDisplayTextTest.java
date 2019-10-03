package ussdDisplayTextTests;

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

public class ussdDisplayTextTest extends baseUSSD {

    @DataProvider(name = "ussdDisplayTextData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "DisplayText/PlainText";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},



        };
    }

    @Test(dataProvider = "ussdDisplayTextData")
    public void ussdSimpleMenu(String msisdn, String sessionID, String network, String type, String msg) {
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.ussdPlainText(msisdn, sessionID, network, type, msg);


    }

}
