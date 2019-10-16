/*
 * The extentReportBuilder class has been created in order to expand on the functionality of the Extent report builder in order to create a more dynamic method to implement reports
 * Author: Juan-Claude Botha
 * */

package baseTest.reportBuilder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.TestListenerAdapter;

public class extentReportBuilder {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;


    // Starts report generator
    public void startReport(String reportDirectory, String documentTitle, String reportName, String hostName, String environment, String user) {
        htmlReporter = new ExtentHtmlReporter(reportDirectory);
        KlovReporter klovReporter = new KlovReporter();
        extent.attachReporter(htmlReporter,klovReporter);
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", hostName);
        extent.setSystemInfo("Environment", environment);
        extent.setSystemInfo("User Name", user);
        htmlReporter.config().setDocumentTitle(documentTitle);
        // Name of the report
        htmlReporter.config().setReportName(reportName);
        // Dark Theme
        htmlReporter.config().setTheme(Theme.DARK);

    }
}
