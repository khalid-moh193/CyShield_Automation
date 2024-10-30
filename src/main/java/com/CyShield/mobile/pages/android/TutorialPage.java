package com.CyShield.mobile.pages.android;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class TutorialPage extends Page {

    public TutorialPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("click on Skip button")
    public HomePage clickOnSkipButton() {
        clickElementByText("Skip");
        return new HomePage(driver);
    }
}
