package com.CyShield.mobiletests;

import com.CyShield.mobile.utils.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public abstract class BaseTestClass {
    public static AppiumDriver driver;
    public SoftAssert softAssert;
    AppDriver appDriver;

    @BeforeSuite
    void setUpTest() {
        appDriver = new AppDriver();
        driver = appDriver.getDriver();
    }

    @BeforeMethod
    void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod
    void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            saveScreenshotPNG();
        }
    }

    @AfterSuite(alwaysRun = true)
    void tearDownTest() {
        appDriver.driverQuit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTestLog(String message) {
        return message;
    }

    @Step("check that value : {0} equal to : {1} ")
    boolean doAssertEqual(Object Actual, Object Expected, String message) {
        softAssert.assertEquals(Actual, Expected, message);
        if (String.valueOf(Expected) != String.valueOf(Actual)) {
            saveScreenshotPNG();
            saveTestLog(message);
            return false;
        }
        return true;
    }
}
