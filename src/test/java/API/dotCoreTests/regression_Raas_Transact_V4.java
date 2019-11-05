/**
 * TestSuite: TransactV4 Regression test suite.
 * Includes all end to end api tests for Transact V4
 * Author: Juan-Claude Botha
 */

package API.dotCoreTests;

import api.testUtilities.testConfig;
import io.restassured.http.ContentType;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.requestLibary.CORE.coreTransactV4POJO;

import api.testUtilities.dataBuilders.testDataFactory;
import api.testUtilities.sqlDataAccessLayer.sqlDataAccess;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class regression_Raas_Transact_V4 extends testConfig {

    @DataProvider(name = "transactV4testcases", parallel = true)
    public Object[] createTransactTestData() throws IOException, ParseException {

        return new String[][]{

                {testDataFactory.getTransaction("transactv4suite","successcase1","accountIdentifier"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","purchaseAmount"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","channelId"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","channelName"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","channelSessionId"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","clientId"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","clientTxnRef"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","productId"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","sourceIdentifier"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","targetIdentifier"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","timestamp"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","reserveFundsTxnRef"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","feeAmount"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","currencyCode"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","fundingSourceId"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","expectedRaasResponseCode"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","expectedMessage"),
                        testDataFactory.getTransaction("transactv4suite","successcase1","expectedRaasRef")},

                {testDataFactory.getTransaction("transactv4suite","successcase2","accountIdentifier"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","purchaseAmount"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","channelId"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","channelName"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","channelSessionId"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","clientId"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","clientTxnRef"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","productId"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","sourceIdentifier"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","targetIdentifier"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","timestamp"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","reserveFundsTxnRef"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","feeAmount"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","currencyCode"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","fundingSourceId"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","expectedRaasResponseCode"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","expectedMessage"),
                        testDataFactory.getTransaction("transactv4suite","successcase2","expectedRaasRef")},


        };
    }

    @Test(dataProvider = "transactV4testcases")
    public void basicTransactV4(String accountIdentifier,
                                String purchaseAmount,
                                String channelId,
                                String channelName,
                                String channelSessionId,
                                String clientId,
                                String clientTxnRef,
                                String productId,
                                String sourceIdentifier,
                                String targetIdentifier,
                                String timeStamp,
                                String reserveFundsTxnRef,
                                String feeAmount,
                                String currencyCode,
                                String fundingSourceId,
                                String expectedRaasResponseCode,
                                String expectedMessage){


        coreTransactV4POJO payload = new coreTransactV4POJO(accountIdentifier,
                purchaseAmount,
                channelId,
                channelName,
                channelSessionId,
                clientId,
                clientTxnRef,
                productId,
                sourceIdentifier,
                targetIdentifier,
                timeStamp,
                reserveFundsTxnRef,
                feeAmount,
                currencyCode,
                fundingSourceId);

        given().
                contentType(ContentType.JSON)
                .log().all()
                .body(payload)
                .when()
                .post("http://docker-minion01.dev.za01.payd.co:30100/raas/v4/transact")
                .then()
                .assertThat()
                .body("responseCode", equalTo(expectedRaasResponseCode))
                .body("responseMessage", equalTo(expectedMessage))
                .body("raasTxnRef.size()", greaterThan(0))
                .log().all()
                .statusCode(200);

    }

    @Test(dataProvider = "transactV4testcases")
    public void transactDbCheck(String accountIdentifier,
                                String purchaseAmount,
                                String channelId,
                                String channelName,
                                String channelSessionId,
                                String clientId,
                                String clientTxnRef,
                                String productId,
                                String sourceIdentifier,
                                String targetIdentifier,
                                String timeStamp,
                                String reserveFundsTxnRef,
                                String feeAmount,
                                String currencyCode,
                                String fundingSourceId,
                                String expectedRaasResponseCode,
                                String expectedMessage,
                                String expectedRaasRef) throws IOException, ParseException, InterruptedException {



        String getRaasReference = sqlDataAccess.verifyPostgreDb("raas.transaction_log","raas_txn_ref", " = ", expectedRaasRef);

        Assert.assertEquals(getRaasReference, expectedRaasRef);

    }
}
