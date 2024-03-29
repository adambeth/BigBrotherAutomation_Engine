/**
 * Implements org.testng.ITestListener
 * Handlers what the system does when test outcomes are triggered
 * Author: Adam Bethlehem
 */


package api.testUtilities.reportBuilder;

import api.testUtilities.testConfig;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerResults extends testConfig implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {

        reportBuilder.logger.info(iTestResult.getMethod().getMethodName() + " has Started");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        reportBuilder.logger.pass(iTestResult.getMethod().getMethodName() + " has passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        reportBuilder.logger.fail(iTestResult.getMethod().getMethodName() + " has failed");
        reportBuilder.logger.fail(iTestResult.getThrowable());


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        reportBuilder.logger.info("What you doing on start");

    }

    @Override
    public void onFinish(ITestContext iTestContext){
//        reportBuilder.extent.flush();

    }
}
