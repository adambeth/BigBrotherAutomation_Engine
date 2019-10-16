package utils.ExtentReports;

import com.aventstack.extentreports.ExtentReports;


//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            extent = new ExtentReports();
        }
        return extent;
    }
}