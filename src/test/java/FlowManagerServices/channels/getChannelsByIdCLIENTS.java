package FlowManagerServices.channels;

import baseTest.testConfig;
import org.testng.annotations.Test;
import api.testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getChannelsByIdCLIENTS extends testConfig {

    @Test
    public void getChannelsByIDClientsUSSDTest() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_getChannels_CLIENT)
                .header("Authorization", header)
                .log().ifValidationFails()
                .when()
                .get("/7")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .body("config.channel-name", equalTo("ussd")).statusCode(200);


    }
}
