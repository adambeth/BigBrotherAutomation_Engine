package FlowManagerServices.flows;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;

public class getClientFlowSteps extends testConfig {

    @Test
    public void getClientFlowStepsTest() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_getFlowSteps_CLIENT)
                .header("Authorization", header)
                .log().ifValidationFails()
                .when()
                .get("/access_bank,Access_Account_Opening")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
