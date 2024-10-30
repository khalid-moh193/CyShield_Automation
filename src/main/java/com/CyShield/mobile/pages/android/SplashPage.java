package com.CyShield.mobile.pages.android;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SplashPage extends Page {
    By changeLanguage = By.xpath("//android.widget.FrameLayout/android.view.ViewGroup[1]");
    public SplashPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("click on change language button")
    public SplashPage changeLanguage() {
        clickElement(changeLanguage);
        return this;
    }

    @Step("click on Continue button")
    public TutorialPage clickOnContinueButton() {
        clickElementByText("Continue");
        return new TutorialPage(driver);
    }
}
