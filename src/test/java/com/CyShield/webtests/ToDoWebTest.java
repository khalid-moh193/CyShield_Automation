package com.CyShield.webtests;

import com.CyShield.web.pages.HomePage;
import com.CyShield.web.pages.RegistrationPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class ToDoWebTest extends BaseTestClass {

    HomePage homePage;
    RegistrationPage registrationPage;

    @Feature("Registration")
    @Test(priority = 1, description = "Verify Registration flow will not be completed with invalid data")
    public void checkAllElementsAreDisplayed() {
        homePage = new HomePage(driver);
        homePage.openHomePage().clickOnTestScenariosMenu().clickOnRegisterFromLink();

        registrationPage = new RegistrationPage(driver);
        assertEqual(registrationPage.checkElementsAreDisplayed(), true, "not all elements are displayed, please check the locators");

        softAssert.assertAll();
    }

    @Feature("Registration")
    @Test(priority = 2, description = "Verify all registration elements are displayed")
    public void registrationInvalidDataTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openHomePage().clickOnTestScenariosMenu().clickOnRegisterFromLink()
                .enterUserID("userId")
                .enterPassword("12345678aA!")
                .enterUsername("testUserName")
                .enterAddress("October")
                .selectCountry(RegistrationPage.Countries.AUSTRALIA)
                .enterZipCode("1234")
                .enterEmail("invalid")
                .selectMaleGender()
                .clickOnSubmitRegistrationButton();

        registrationPage = new RegistrationPage(driver);
        assertEqual(registrationPage.getAlertText(), "You have entered an invalid email address!", "Alert text is wrong, it should inform us about the email field");
        assertEqual(registrationPage.getCurrentUrl().contains("register-form"), true, "the URL is wrong, check if the registration validation is working as expected");

        softAssert.assertAll();
    }

    @Feature("Registration")
    @Test(priority = 3, description = "Verify Registration flow will not be completed with invalid data")
    public void registrationValidDataTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openHomePage().clickOnTestScenariosMenu().clickOnRegisterFromLink()
                .enterUserID("userId")
                .enterPassword("12345678aA!")
                .enterUsername("testUserName")
                .enterAddress("October")
                .selectCountry(RegistrationPage.Countries.AUSTRALIA)
                .enterZipCode("1234")
                .enterEmail("test@gmail.com")
                .selectMaleGender()
                .clickOnSubmitRegistrationButton();

        registrationPage = new RegistrationPage(driver);
        assertEqual(registrationPage.getCurrentUrl().contains("testUserName"), true, "the URL is wrong, it seems that the registration didn't complete, check if there is any validation alerts");

        softAssert.assertAll();
    }


}
