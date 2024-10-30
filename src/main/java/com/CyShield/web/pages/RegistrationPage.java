package com.CyShield.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends Page {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By userIDField = By.name("userid");
    private final By passwordField = By.name("passid");
    private final By usernameField = By.name("username");
    private final By addressField = By.name("address");
    private final By countryDropDown = By.name("country");
    private final By zipCodeField = By.name("zip");
    private final By emailField = By.name("email");
    private final By maleGenderButton = By.xpath("//input[@value='Male']");
    private final By submitButton = By.name("submit");

    @Step("enter user id")
    public RegistrationPage enterUserID(String userID) {
        sendText(userIDField, userID);
        return this;
    }

    @Step("enter password")
    public RegistrationPage enterPassword(String password) {
        sendText(passwordField, password);
        return this;
    }

    @Step("enter username")
    public RegistrationPage enterUsername(String username) {
        sendText(usernameField, username);
        return this;
    }

    @Step("enter Address")
    public RegistrationPage enterAddress(String address) {
        sendText(addressField, address);
        return this;
    }

    @Step("select country")
    public RegistrationPage selectCountry(Countries country) {
        Select dropdown = new Select(driver.findElement(countryDropDown));
        dropdown.selectByVisibleText(country.getValue());
        return this;
    }

    @Step("enter zip code")
    public RegistrationPage enterZipCode(String zipCode) {
        sendText(zipCodeField, zipCode);
        return this;
    }

    @Step("enter email")
    public RegistrationPage enterEmail(String email) {
        sendText(emailField, email);
        return this;
    }

    @Step("select Male Gender")
    public RegistrationPage selectMaleGender() {
        clickElement(maleGenderButton);
        return this;
    }

    @Step("click on submit button")
    public HomePage clickOnSubmitRegistrationButton() throws InterruptedException {
        clickElement(submitButton);
        Thread.sleep(500);
        return new HomePage(driver);
    }

    @Step("Check all elements are displayed")
    public boolean checkElementsAreDisplayed() {
        checkElementIsDisplayed(userIDField);
        checkElementIsDisplayed(passwordField);
        checkElementIsDisplayed(usernameField);
        checkElementIsDisplayed(addressField);
        checkElementIsDisplayed(countryDropDown);
        checkElementIsDisplayed(zipCodeField);
        checkElementIsDisplayed(emailField);
        return checkElementIsDisplayed(maleGenderButton);
    }

    public enum Countries {
        AUSTRALIA("Australia"),
        Canada("Canada"),
        India("India"),
        Russia("Russia"),
        USA("USA");

        private String value;

        Countries(String value) {
            this.setValue(value);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}




