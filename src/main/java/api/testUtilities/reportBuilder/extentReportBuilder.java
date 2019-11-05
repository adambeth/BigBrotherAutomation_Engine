/**
 * The extentReportBuilder class has been created in order to expand on the functionality of the Extent report builder in order to create a more dynamic method to implement reports
 * Author: Juan-Claude Botha
 * Supports both online and offline reporting
 * https://extentreports.com/docs/versions/4/java/klov-reporter.html
 */

package api.testUtilities.reportBuilder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class extentReportBuilder {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent = new ExtentReports();
    public ExtentTest logger;
    public ExtentKlovReporter klovReporter  =new ExtentKlovReporter();;


    /**
     * Create object of Klov Report for historical reporting
     * Requires Mongo DB 3.2
     * Requires klov server jar to be running
     * Online / Offline flag set in config.properties REPORTING = ${REPORTING}
     */
    public void startReport(String reportDirectory, String documentTitle, String reportName, String hostName, String environment, String user) {
        Properties properties = loadPropertiesFile("config.properties");
        String environmentName = properties.getProperty("ENVIRONMENT");
//       String reporting = properties.getProperty("REPORTING");
        String reporting ="false";


        if (reporting == "true") {

            htmlReporter = new ExtentHtmlReporter(reportDirectory);

            klovReporter.initMongoDbConnection("localhost", 27017);
            klovReporter.setProjectName("Big Brother Is Watching");
            klovReporter.setReportName(reportName);
            klovReporter.initKlovServerConnection("http://localhost");


            extent.attachReporter(htmlReporter, klovReporter);
            extent.setSystemInfo("Host Name", hostName);
            extent.setSystemInfo("Environment", environmentName);
            extent.setSystemInfo("User Name", user);
            htmlReporter.config().setDocumentTitle(documentTitle);
            // Name of the report
            htmlReporter.config().setReportName(reportName);
            // Dark Theme
            htmlReporter.config().setTheme(Theme.DARK);
        }

        //offline reporting
        else if (reporting =="false"){
            htmlReporter = new ExtentHtmlReporter(reportDirectory);
//            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", hostName);
            extent.setSystemInfo("Environment", environmentName);
            extent.setSystemInfo("User Name", user);
            htmlReporter.config().setDocumentTitle(documentTitle);
            // Name of the report
            htmlReporter.config().setReportName(reportName);
            // Dark Theme
            htmlReporter.config().setTheme(Theme.DARK);


        }
    }

    public static void main(String[] args) {
        System.out.println(loadPropertiesFile("config.properties"));
    }

    //TODO create class
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
}
