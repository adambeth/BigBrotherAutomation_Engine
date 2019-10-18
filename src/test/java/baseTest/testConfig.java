package baseTest;

import com.aventstack.extentreports.reporter.KlovReporter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.*;
import baseTest.reportBuilder.extentReportBuilder;

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
    public static KlovReporter klovReporter = new KlovReporter();

    @BeforeClass

    public void setUp() {


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
//http://docker-minion01.dev.za01.payd.co:31915/fundingsource/confirm
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

