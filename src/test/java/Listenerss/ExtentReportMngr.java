package Listenerss;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//this is utility file
public class ExtentReportMngr implements ITestListener {
    //used for UI parts of the report
    public ExtentSparkReporter sparkReporter;
    //used for commonly info of the report
    public ExtentReports extent;
   //Used for info the test methods in the report
    public ExtentTest test;

    public void onStart(ITestContext context) {
        //here, we have hardcoded the report name, so each time the original report is getting replaced. The history is reocrded.ie we cannot compare the new report to old.
        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreports.html");
        sparkReporter.config().setDocumentTitle("Automation report");
        sparkReporter.config().setReportName("Funtional Tests");
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
//this also we can achieve at the runtime.
        extent.setSystemInfo("Computer Name", "local host");
        extent.setSystemInfo("Environment Name", "QA");
        extent.setSystemInfo("Tester Name", "Aditya");
        extent.setSystemInfo("OS", "Linux mint");
        extent.setSystemInfo("Browser", "chrome");
    }
    //this method will be executed each time before test methods run.
    public void onTestStart(ITestResult result) {
        System.out.println("test method execution.....");
    }
    public void onTestSuccess(ITestResult result) {
        test=extent.createTest(result.getName());//creates a new entry in the report
        test.log(Status.PASS, "Test case passed is: "+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        //screenshot attachement of the failed cases can be done here.
        test=extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case failed is: "+result.getName());
        test.log(Status.FAIL, "Test case fail reason is: "+result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test=extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped is: "+result.getName());
        test.log(Status.SKIP, "Test case skip reason is: "+result.getThrowable());
    }
    //this will execute after all test methods are completed.
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("All test methods execution completed...");
    }

}
