package Listenerss;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Mylistener implements ITestListener {
    //this method will be executed once for a class before starting any test methods
    public void onStart(ITestContext context) {
        System.out.println("test execution started.....");
    }
    //this method will be executed each time before test methods run.
    public void onTestStart(ITestResult result) {
        System.out.println("test method execution.....");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("test is passed... "+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("test is failed... "+result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test is skipped... "+result.getName());
    }
    //this will execute after all test methods are completed.
    public void onFinish(ITestContext context) {
        System.out.println("All test methods execution completed...");
    }
}
