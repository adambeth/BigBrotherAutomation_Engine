package FlowManagerServices.channels;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getChannelFUNDINGSOURCEDefault extends testConfig {
    @Test
    public void getDefaultChannelsFUNDINGSOURCESTest() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_getChannels_FUNDING_SOURCE)
                .header("Authorization", header)
                .log().all()
                .when()
                .get("/0")
                .then()
                .log().all()
                .assertThat()
                .body("config.channel-name", equalTo("DEFAULT"))
                .statusCode(200);


    }
}