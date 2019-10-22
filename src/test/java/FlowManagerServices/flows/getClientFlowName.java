package FlowManagerServices.flows;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;

public class getClientFlowName extends testConfig {

    @Test
    public void getClientFlowNameTest() {


        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;
        //todo add validation
        given()
                .spec(FM_getFlowName_CLIENT)
                .header("Authorization", header)
                .log().ifValidationFails()
                .when()
                .get("/access_bank,Access_Account_Opening")
                .then()
                .log().ifValidationFails()
                .assertThat().statusCode(200);


    }
}
