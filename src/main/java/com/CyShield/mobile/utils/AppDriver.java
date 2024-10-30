package com.CyShield.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppDriver {
    TouchAction touchAction;
    static AppiumDriver driver;
    DesiredCapabilities capabilities;
    AppiumDriverLocalService app_service;
    private AppiumServiceBuilder builder;

    public AppDriver() {
        startAppiumServer();
        initializeDriver();
    }

    private void startAppiumServer() {

        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingAnyFreePort();
        builder.withArgument(() -> "--base-path", "/wd/hub");
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");//debug or error

        app_service = AppiumDriverLocalService.buildService(builder);
        app_service.start();
    }

    public void initializeDriver() {

        capabilities = MobileCapabilitiesConfig.getCapabilities();

        try {
            driver = new AndroidDriver(app_service, capabilities);
            touchAction = new TouchAction((PerformsTouchActions) getDriver());

        } catch (Exception e) {
            System.out.println("error happened during env init please enable debug to get useful info ");
            e.printStackTrace();
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void driverQuit() {
        driver.quit();
        app_service.stop();
    }
}
