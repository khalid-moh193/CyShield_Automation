package com.CyShield.mobile.pages.android;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends Page {

    By profileTab = By.xpath("//android.widget.Button[5]");
    By discoverTab = By.xpath("//android.widget.Button[1]");

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Navigate to Discover Tab")
    public HomePage NavigateToDiscoverTab() {
        clickElementByText("Discover");
        return this;
    }

    @Step("Navigate to Groups Tab")
    public HomePage NavigateToGroupsTab() {
        clickElementByText("Groups");
        return this;
    }

    @Step("Navigate to Organization Tab")
    public HomePage NavigateToOrganizationTab() {
        clickElementByText("Organization");
        return this;
    }

    @Step("Navigate to Events Tab")
    public HomePage NavigateToEventsTab() {
        clickElementByText("Events");
        return this;
    }

    @Step("Navigate to Profile Tab")
    public HomePage NavigateToProfileTab() {
        clickElementByText("Profile");
        return this;
    }

    @Step("check that Profile tab is selected")
    public boolean checkThatProfileTabIsSelected() {
        return checkElementIsSelected(profileTab);
    }

    @Step("check that discover tab is selected")
    public boolean checkThatDiscoverTabIsSelected() {
        return checkElementIsSelected(discoverTab);
    }

}
