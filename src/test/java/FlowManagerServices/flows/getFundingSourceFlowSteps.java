package FlowManagerServices.flows;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;

public class getFundingSourceFlowSteps extends testConfig {

    @Test
    public void getFundingSourceFlowStepsTest() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_getFlowSteps_FUNDINGSOURCE)
                .header("Authorization", header)
                .log().ifValidationFails()
                .when()
                .get("/nestedSetBehaviourField")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}