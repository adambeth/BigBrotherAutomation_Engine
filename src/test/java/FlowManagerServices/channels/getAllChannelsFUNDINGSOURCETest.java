package FlowManagerServices.channels;

import baseTest.testConfig;
import org.testng.annotations.Test;
import testUtilities.authentication.keyCloakProvider;

import static io.restassured.RestAssured.given;


public class getAllChannelsFUNDINGSOURCETest extends testConfig {

    @Test
    public void getAllChannelsFUNDINGSOURCESTest() {

        keyCloakProvider keyCloakProvider = new keyCloakProvider();
        String key = keyCloakProvider.getAccessToken();
        String header = "Bearer " + key;

        given()
                .spec(FM_getChannels_FUNDING_SOURCE)
                .header("Authorization", header)
                .log().all()
                .when()
                .get()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);


    }
}
