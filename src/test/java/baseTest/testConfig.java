package baseTest;

import baseTest.reportBuilder.extentReportBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class testConfig {
    /*
    All .Control Request Specification
     */
    public static RequestSpecification PWM_ReserveFunds_RequestSpec;
    public static RequestSpecification PWM_ReserveFunds_Behaviour_RequestSpec;
    public static RequestSpecification PWM_Confirmation_RequestSpec;
    public static RequestSpecification PWM_Confirmation_Behaviour_RequestSpec;
    public static RequestSpecification PWM_Lookup_RequestSpec;
    public static RequestSpecification PWM_Lookup_Behaviour_RequestSpec;

    public static RequestSpecification MWM_Ping_RequestSpec;
    public static RequestSpecification MWM_Vend_RequestSpec;
    public static RequestSpecification MWM_VendLookUp_RequestSpec;
    public static extentReportBuilder reportBuilder = new extentReportBuilder();

    public static RequestSpecification FM_GetClients_CLIENTS;
    public static RequestSpecification FM_GetClients_VENDORS;
    public static RequestSpecification FM_GetClients_FUNDINGSOURCES;
    public static RequestSpecification FM_GetFlows_CLIENTS;
    public static RequestSpecification FM_GetFlows_VENDORS;
    public static RequestSpecification FM_GetFlows_FUNDING_SOURCE;
    public static RequestSpecification FM_GetFlowSingle_CLIENTS;
    public static RequestSpecification FM_GetFlowSingle_VENDOR;
    public static RequestSpecification FM_GetFlowSingle_FUNDING_SOURCE;

    public static RequestSpecification FM_getChannels_FUNDING_SOURCE;
    public static RequestSpecification FM_getChannels_CLIENT;
    public static RequestSpecification FM_getChannels_VENDOR;

    public static RequestSpecification FM_getFlowSteps_CLIENT;
    public static RequestSpecification FM_getFlowSteps_FUNDINGSOURCE;
    public static RequestSpecification FM_getFlowSteps_VENDOR;

    public static RequestSpecification FM_getEndPoints_CLIENT;
    public static RequestSpecification FM_getEndPoints_VENDOR;
    public static RequestSpecification FM_getEndPoints_FUNDINGSOURCE;

    public static RequestSpecification FM_getFlowName_CLIENT;
    public static RequestSpecification FM_getFlowName_VENDOR;
    public static RequestSpecification FM_getFlowName_FUNDINGSOURCE;








    @BeforeClass

    public void setUp() {

        FM_getFlowName_FUNDINGSOURCE = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/FUNDING_SOURCE/249/flow")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_getFlowName_VENDOR = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/VENDOR/21/flow")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_getFlowName_CLIENT = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/CLIENT/42/flow")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_getEndPoints_FUNDINGSOURCE = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/FUNDING_SOURCE/249/endpoints")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();


        FM_getEndPoints_VENDOR = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/VENDOR/21/endpoints")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_getEndPoints_CLIENT = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/CLIENT/42/endpoints")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();


        FM_getFlowSteps_FUNDINGSOURCE = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/FUNDING_SOURCE/249/steps/")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();
        FM_getFlowSteps_CLIENT = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/CLIENT/42/steps/")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_getChannels_VENDOR = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/VENDOR/21/channels")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();


        FM_getChannels_CLIENT = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/CLIENT/42/channels")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_getChannels_FUNDING_SOURCE = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/FUNDING_SOURCE/249/channels")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();
        FM_GetFlowSingle_FUNDING_SOURCE = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/FUNDING_SOURCE/249/flows")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetFlowSingle_VENDOR = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/VENDOR/21/flows")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetFlowSingle_CLIENTS = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/CLIENT/101/flows")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();


        FM_GetFlows_FUNDING_SOURCE = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/FUNDING_SOURCE/249/flows")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetFlows_VENDORS = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/VENDOR/21/flows")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();


        FM_GetFlows_CLIENTS = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/api/dev/CLIENT/42/flows")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetClients_FUNDINGSOURCES = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/management/dev/FUNDING_SOURCE")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetClients_CLIENTS = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/management/dev/CLIENT")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetClients_VENDORS = new RequestSpecBuilder()
                .setBaseUri("http://control-ui-backend.qa.za01.payd.co")
                .setBasePath("/management/dev/VENDOR")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "control-ui-backend.qa.za01.payd.co")
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();



        PWM_ReserveFunds_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31915).
                setBasePath("/fundingsource/reserve").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                addHeader("fundingSourceId","249").
                build().log().all();

        PWM_ReserveFunds_Behaviour_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31914).
                setBasePath("/api/FUNDING_SOURCE/249/apiBehaviour/EJ-Fc5kR9HemVCuM/set/reserve").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        PWM_Confirmation_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31915).
                setBasePath("/fundingsource/confirm").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                addHeader("fundingSourceId","249").
                build();

        PWM_Confirmation_Behaviour_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31915).
                setBasePath("/api/FUNDING_SOURCE/249/apiBehaviour/EJ-Fc5kR9HemVCuM/set/confirm").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        PWM_Lookup_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31914).
                setBasePath("/api/FUNDING_SOURCE/249/apiTxnLookup/-aESIfw1mwedxvA-/lookup").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        PWM_Lookup_Behaviour_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31914).
                setBasePath("/api/FUNDING_SOURCE/249/apiBehaviour/EJ-Fc5kR9HemVCuM/set/lookup").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        MWM_Ping_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31910).
                setBasePath("/vendor/ping").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        MWM_Vend_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31910).
                setBasePath("/vendor/vend").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        MWM_VendLookUp_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31910).
                setBasePath("/vendor/lookup").
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();


    }



    @BeforeTest
    public void setExtent(ITestContext iTestContext) {


        reportBuilder.logger = reportBuilder.extent.createTest(iTestContext.getName());
    }

}

