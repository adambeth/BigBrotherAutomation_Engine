package baseTest.reportBuilder;

import baseTest.testConfig;
import org.testng.ISuite;

public class ISuiteListener extends testConfig implements org.testng.ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        String reportPath = System.getProperty("user.dir") + "/Reports/USSD_Test_Report.html";
        String documentTitle = "dotControl Automation Test Report";
        String reportName = "USSD Test Report";
        String hostName = "restAssuredSuite";
        String environment = "QA";
        String user = "jc";
        reportBuilder.startReport(reportPath, documentTitle, reportName, hostName, environment, user);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        reportBuilder.extent.flush();

    }
}
