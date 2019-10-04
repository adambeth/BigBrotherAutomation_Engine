package isEmptyTests;

import baseTest.baseUSSD;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestLibaryUSSD.ussd;
import testUtilities.ussd.createUSSDData;

import java.util.UUID;

public class isEmptySimpleNullTest extends baseUSSD {

    @DataProvider(name = "isEmptySimpleNullData", parallel = true)
    public Object[] createUSSDTestData() {
        String message = "IsEmpty/SimpleTestNull";
        return new String[][]{

                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(), "1", "1", message},


        };
    }

    @Test(dataProvider = "isEmptySimpleNullData")
    public void ussdIsEmptySimpleNullTest(String msisdn, String sessionID, String network, String type, String msg) {
        createUSSDData x = new createUSSDData();
        ussd payLoad = x.getIsEmptySimpleUSSD(msisdn, sessionID, network, type, msg);


    }


}