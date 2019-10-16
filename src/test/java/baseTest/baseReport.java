/**
 * This class is to to test all the permutations of the OPTION 2 of the USSD String
 * Author: Adam Bethlehem
 */

package baseTest;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import baseTest.reportBuilder.extentReportBuilder;



public class baseReport extends baseUSSD {


    // Create new instance of report builder class in order to generate test outcome report
    extentReportBuilder reportBuilder = new extentReportBuilder();
//    reportConfig reportCon = new reportConfig();

    // Global variables -- The below needs to recide within the global configurations class in order to
    // inherit from and be easily customizable (TO DO)
    String reportPath = System.getProperty("user.dir") + "/Reports/USSD_Test_Report.html";
    String documentTitle = "dotControl Automation Test Report";
    String reportName = "USSD Test Report";
    String hostName = "restAssuredSuite";
    String environment = "QA";
    String user = "jc";


    // Set extend report paramenters to generate report before test is run
    @BeforeTest
    public void setExtent(ITestContext iTestContext) {

        reportBuilder.startReport(reportPath, documentTitle, reportName, hostName, environment, user);
        reportBuilder.logger = reportBuilder.extent.createTest("We want to put the test methof name here");
    }

    // Clear report data after test is run
    @AfterTest
    public void endReport() {
        reportBuilder.extent.flush();
    }


//
//    @Test()
//    public void startSessiona() {
//        System.out.println("THIS IS OUR TEST BITHCES2");
//        // reportBuilder.logger = reportBuilder.extent.createTest("Test Methods");
//        reportBuilder.logger.pass("JC");
//
//    }

}