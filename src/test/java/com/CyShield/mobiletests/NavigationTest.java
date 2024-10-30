package com.CyShield.mobiletests;

import com.CyShield.mobile.pages.android.HomePage;
import com.CyShield.mobile.pages.android.SplashPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTestClass {

    SplashPage splash;
    HomePage homePage;

    @Feature("Navigation")
    @Test(priority = 1, description = "make sure that navigation through the screens is working fine")
    public void navigationTest() {
        splash = new SplashPage(driver);
        splash.clickOnContinueButton()
                .clickOnSkipButton()
                .NavigateToProfileTab();
        homePage = new HomePage(driver);
        doAssertEqual(homePage.checkThatProfileTabIsSelected(), true, "Profile tab is not selected");
        doAssertEqual(homePage.checkThatDiscoverTabIsSelected(), false, "Discover tab is not selected");
        softAssert.assertAll();

    }


}
