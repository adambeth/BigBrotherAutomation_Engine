package baseTest;

import baseTest.reportBuilder.extentReportBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

    @BeforeClass
    public void setUp() {
        Properties properties = loadPropertiesFile("config.properties");

        FM_GetClients_FUNDINGSOURCES = new RequestSpecBuilder()
                .setBaseUri(properties.getProperty("FM_GetClients_FUNDINGSOURCES_BaseUri"))
                .setBasePath(properties.getProperty("FM_GetClients_FUNDINGSOURCES_BasePath"))
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", properties.getProperty("FM_GetClients_FUNDINGSOURCES_Host"))
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetClients_CLIENTS = new RequestSpecBuilder()
                .setBaseUri(properties.getProperty("FM_GetClients_CLIENTS_BaseUri"))
                .setBasePath(properties.getProperty("FM_GetClients_CLIENTS_BasePath"))
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", properties.getProperty("FM_GetClients_CLIENTS_Host"))
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();

        FM_GetClients_VENDORS = new RequestSpecBuilder()
                .setBaseUri(properties.getProperty("FM_GetClients_VENDORS_BaseUri"))
                .setBasePath(properties.getProperty("FM_GetClients_VENDORS_BasePath"))
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", properties.getProperty("FM_GetClients_VENDORS_Host"))
                .addHeader("Accept-Encoding", "Accept-Encoding")
                .addHeader("Connection", "keep-alive").build();



        PWM_ReserveFunds_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("PWM_ReserveFunds_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("PWM_ReserveFunds_RequestSpec_Port"))).
                setBasePath(properties.getProperty("PWM_ReserveFunds_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                addHeader("fundingSourceId","249").
                build().log().all();

        PWM_ReserveFunds_Behaviour_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("PWM_ReserveFunds_Behaviour_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("PWM_ReserveFunds_Behaviour_RequestSpec_Port"))).
                setBasePath(properties.getProperty("PWM_ReserveFunds_Behaviour_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        PWM_Confirmation_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("PWM_Confirmation_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("PWM_Confirmation_RequestSpec_Port"))).
                setBasePath(properties.getProperty("PWM_Confirmation_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                addHeader("fundingSourceId","249").
                build();

        PWM_Confirmation_Behaviour_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("PWM_Confirmation_Behaviour_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("PWM_Confirmation_Behaviour_RequestSpec_Port"))).
                setBasePath(properties.getProperty("PWM_Confirmation_Behaviour_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        PWM_Lookup_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("PWM_Lookup_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("PWM_Lookup_RequestSpec_Port"))).
                setBasePath(properties.getProperty("PWM_Lookup_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        PWM_Lookup_Behaviour_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("PWM_Lookup_Behaviour_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("PWM_Lookup_Behaviour_RequestSpec_Port"))).
                setBasePath(properties.getProperty("PWM_Lookup_Behaviour_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        MWM_Ping_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("MWM_Ping_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("MWM_Ping_RequestSpec_Port"))).
                setBasePath(properties.getProperty("MWM_Ping_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        MWM_Vend_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("MWM_Vend_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("MWM_Vend_RequestSpec_Port"))).
                setBasePath(properties.getProperty("MWM_Vend_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();

        MWM_VendLookUp_RequestSpec = new RequestSpecBuilder().
                setBaseUri(properties.getProperty("MWM_VendLookUp_RequestSpec_BaseUri")).
                setPort(Integer.parseInt(properties.getProperty("MWM_VendLookUp_RequestSpec_Port"))).
                setBasePath(properties.getProperty("MWM_VendLookUp_RequestSpec_BasePath")).
                setContentType(ContentType.JSON).
                addHeader("Content-Type", "json").
                build();


    }

    public static void main(String[] args) {
        System.out.println(loadPropertiesFile("config.properties"));
    }

    public static Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);
//            InputStream resourceAsStream = testConfig.class.getClassLoader().getResourceAsStream(filePath);
            prop.load(inputStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }

    @BeforeTest
    public void setExtent(ITestContext iTestContext) {


        reportBuilder.logger = reportBuilder.extent.createTest(iTestContext.getName());
    }

}

