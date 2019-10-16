package baseTest.reportBuilder;

import baseTest.testConfig;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

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
    public void onFinish(ITestContext iTestContext) {

    }
}
