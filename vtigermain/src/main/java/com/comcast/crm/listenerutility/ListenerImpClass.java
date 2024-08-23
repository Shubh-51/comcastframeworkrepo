package com.comcast.crm.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass1;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {

    public ExtentSparkReporter spark;
    public  ExtentReports report;
    public static ExtentTest test;

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Report Configuration");
        String time=new Date().toString().replace(" ", "_").replace(":", "_");
        spark = new ExtentSparkReporter("./AdvanceReport/report_+"+time+".html");
        spark.config().setDocumentTitle("CRM Report Suite");
        spark.config().setReportName("CRM Report");
        spark.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("OS", "Windows-12");
        report.setSystemInfo("Browser", "Browser-120");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Report backup");
        report.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("======>" + result.getMethod().getMethodName() + "<====START====");
        test = report.createTest(result.getMethod().getMethodName());
        UtilityClassObject.setTest(test);
        test.log(Status.INFO, result.getMethod().getMethodName() + "======>STARTED<======");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("======>" + result.getMethod().getMethodName() + "<=====END===");
        test.log(Status.PASS, result.getMethod().getMethodName() + "====>Completed<=====");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testname = result.getMethod().getMethodName();
        String time = new Date().toString().replace(" ", "_").replace(":", "_");

        // Check if test object is initialized
        if (test != null) {
            TakesScreenshot ts = (TakesScreenshot) BaseClass1.sdriver;
            try {
                String filepath = ts.getScreenshotAs(OutputType.BASE64);
                test.addScreenCaptureFromBase64String(filepath, testname + "_" + time);
                test.log(Status.FAIL, result.getMethod().getMethodName());
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("ExtentTest object is null. Cannot add screenshot.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Handle skipped test
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Handle test failure within success percentage
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // Handle test failure due to timeout
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional context start logic
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optional context finish logic
    }
}
