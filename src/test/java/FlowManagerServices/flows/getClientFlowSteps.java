package FlowManagerServices.flows;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
                .assertThat()
                .body("[2]",equalTo("step19"))
                .body("[3]",equalTo("step2"))
                .body("[4]",equalTo("step21"))
                .body("[5]",equalTo("step3"))
                .body("[13]",equalTo("step6"))
                .statusCode(200);
    }
}
