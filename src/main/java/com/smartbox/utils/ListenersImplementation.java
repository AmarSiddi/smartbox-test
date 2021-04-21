package com.smartbox.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.smartbox.base.ExtentFactory;
import com.smartbox.base.ExtentReportNG;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {

    static ExtentReports report;
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    public void onTestSuccess(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public void onTestFailure(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

        //TODO can implement functionality to capture the screenshot on test failure
    }

    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        try {
            report = ExtentReportNG.setupExtentReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        report.flush();
    }
}
