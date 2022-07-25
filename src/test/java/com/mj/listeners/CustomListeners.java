package com.mj.listeners;

import com.mj.util.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtil.getScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
          }
        Reporter.log("Capturing Screenshot");
        String path = TestUtil.screenshotName;
        //Reporter.log(path);
        Reporter.log("<a href=\"html\\"+TestUtil.screenshotName+"\">Screenshot</a>");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
