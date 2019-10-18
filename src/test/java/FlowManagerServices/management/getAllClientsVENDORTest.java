package FlowManagerServices.management;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getAllClientsVENDORTest extends testConfig {


    @Test
    public void getallCLIENTS() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_GetClients_VENDORS)
                .header("Authorization", header).log().all()
                .when().get().then().log().all().assertThat().body("21", equalTo("Test_Vendor_NG")).statusCode(200);


    }
}
