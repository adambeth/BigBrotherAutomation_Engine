package baseTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class baseTest {

    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    ExtentReports extent = new ExtentReports();
  //  extent.attachReporter(htmlReporter)

}
