package Repoting;
import com.aventstack.extentreports.Status;
import org.testng.*;

public final class ListenerClass implements IClassListener,ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite){
        ExtentReporting.initReport();
    }
    @Override
    public void onFinish(ISuite suite){
        ExtentReporting.flushReport();
    }
    @Override
    public void onTestStart(ITestResult result){
        ExtentReporting.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        ExtentLogger.pass(result.getMethod().getMethodName());
    }
    @Override
    public void onTestFailure(ITestResult result){
        ExtentLogger.fail(result.getMethod().getMethodName());
        ExtentManager.getExtentTest().log(Status.INFO, "StackTrace Result: <br/>" +result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result){
        ExtentLogger.skip(result.getMethod().getMethodName());
        ExtentManager.getExtentTest().log(Status.INFO, "StackTrace Result: <br/>" +result.getThrowable());
    }
}

