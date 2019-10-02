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
        String message = "AskForInput/PlainText";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},



        };
    }

    @Test(dataProvider = "askForInputData")
    public void askForInputTest(String msisdn, String sessioID, String network, String type, String msg){
        createUSSDData x = new createUSSDData();
        ussd payLoad;
        payLoad = x.ussdPlainText(msisdn,sessioID,network,type,msg );


    }
}
