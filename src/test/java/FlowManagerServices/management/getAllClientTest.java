package FlowManagerServices.management;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

public class getAllClientTest extends testConfig {

    @Test
    public void test() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        System.out.println(key);


    }
}
