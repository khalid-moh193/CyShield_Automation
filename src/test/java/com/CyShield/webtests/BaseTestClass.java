package com.CyShield.webtests;

import com.CyShield.web.utils.AppDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public abstract class BaseTestClass {
    public WebDriver driver;
    public SoftAssert softAssert;

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTestLog(String message) {
        return message;
    }


    @BeforeClass()
    @Parameters("browser")
    void beforeClass(@Optional("chrome") String browser) throws Exception {
        AppDriver testInit = new AppDriver();
        driver = testInit.SeleniumDriverSetup(browser);
    }

    @BeforeMethod()
    void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod()
    void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            saveScreenshotPNG();
        }
    }

    @AfterClass(groups = {"setup"})
    void afterClass() {
        driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("check that value : {0} equal to : {1} ")
    boolean assertEqual(Object Actual, Object Expected, String message) {
        softAssert.assertEquals(Actual, Expected, message);
        if (String.valueOf(Expected) != String.valueOf(Actual)) {
            saveScreenshotPNG();
            saveTestLog(message);
            return false;
        }

        return true;
    }

}