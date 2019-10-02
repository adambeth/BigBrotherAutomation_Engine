package baseTest;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class testConfig {

    public static RequestSpecification financial_terms_controller;
    public static RequestSpecification ussd_POST;

    public static XmlMapper xmlMapper = new XmlMapper();

    @BeforeClass

    public void setUp() {
        String className = this.getClass().getSimpleName();

        RestAssured.proxy("localhost",8888);
        ussd_POST = new RequestSpecBuilder().
                setBaseUri("http://docker-minion01.dev.za01.payd.co").
                setPort(31905).
                setBasePath("/trutequ/ussd/").
                setContentType(ContentType.XML).

                build();

        financial_terms_controller = new RequestSpecBuilder().
                setBaseUri("http://docker-minion04.dev.za01.payd.co").
                setPort(30309).
                setBasePath("/financial-terms").
                addHeader("Content-Type","json").
                build();



    }

    @AfterClass
    public void generateReport( ){
//        ITestResult result = null;
//       // ITestContext contextresults = null;{
//            try
//            {
//                if(result.getStatus() == ITestResult.SUCCESS)
//                {
//                    test.info("Test PASSED");
//                    test.pass("Test Passed");
//                }
//                else if(result.getStatus() == ITestResult.FAILURE)
//                {
//                    test.info("Test FAILED");
//                   test.fail("Test Failed");
//
//                }
//                else if(result.getStatus() == ITestResult.SKIP)
//                { test.info("Test SKIPPED");
//                   test.skip("SKIPPER");
//
//                }
//            }
//            catch(Exception e)
//            {
//                System.out.println("\nLog Message::@AfterMethod: Exception caught");
//                e.printStackTrace();
//            }
//        extent.flush();
    }
}

