package FlowManagerServices.management;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class getAllClientsFUNDINGSOURCETest extends testConfig {

    @Test
    public void getAllFundingSources() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_GetClients_FUNDINGSOURCES)
                .header("Authorization", header).log().all()
                .when().get().then().log().all().assertThat().body("249", equalTo("Test Funding Source PWM")).statusCode(200);


    }
}