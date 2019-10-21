package FlowManagerServices.flows;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;

public class getFlowByCLIENTTest extends testConfig {


    @Test
    public void getFlowsbyClient() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_GeFlows_CLIENTS)
                .header("Authorization", header)
                .log().ifValidationFails()
                .when()
                .get()
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200);


    }


}


