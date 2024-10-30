package com.CyShield.web.pages;

import com.CyShield.web.utils.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By testScenariosMenu = By.xpath("//ul[@id = 'menu-menu-1']//li[5]");
    private final By registerFormLink = By.xpath("//a[contains(text(),'Register Form')]");


    @Step("-Open Home page")
    public HomePage openHomePage() {
        openURL(URLs.Page.HOME.getValue());
        return this;
    }

    @Step("click on test Scenarios menu")
    public HomePage clickOnTestScenariosMenu() {
        clickElement(testScenariosMenu);
        return this;
    }

    @Step("click on register From link")
    public RegistrationPage clickOnRegisterFromLink() {
        clickElement(registerFormLink);
        return new RegistrationPage(driver);
    }

}




