package com.CyShield.mobile.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileCapabilitiesConfig {

    public static DesiredCapabilities getCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appPackage", "com.uxbert.sfa");
        capabilities.setCapability("appWaitPackage", "com.uxbert.sfa.MainActivity");
        capabilities.setCapability("appActivity", "com.uxbert.sfa.MainActivity");
        capabilities.setCapability("platformVersion", PropertyReader.getProperty("android.platformVersion"));
        capabilities.setCapability("deviceName", PropertyReader.getProperty("android.deviceName"));
        capabilities.setCapability("noReset", PropertyReader.getProperty("android.noReset"));


        capabilities.setCapability("automationName", PropertyReader.getProperty("android.automationName"));
        capabilities.setCapability("platformName", PropertyReader.getProperty("platformName"));
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("clearSystemFiles", PropertyReader.getProperty("android.clearSystemFiles"));
        capabilities.setCapability("autoGrantPermissions", PropertyReader.getProperty("android.autoGrantPermissions"));
        capabilities.setCapability("ignoreUnimportantViews", true);

        return capabilities;
    }

}
