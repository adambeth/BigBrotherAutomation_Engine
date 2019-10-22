package FlowManagerServices.flows;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;

public class getFUNDINGSOURCEFlowNameTest extends testConfig {

    @Test
    public void getFUNDINGSOURCEFlowNameTest() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;
        //todo add validation
        given()
                .spec(FM_getFlowName_FUNDINGSOURCE)
                .header("Authorization", header)
                .log().ifValidationFails()
                .when()
                .get("/fundingSourceConfirm")
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200);
    }
}
