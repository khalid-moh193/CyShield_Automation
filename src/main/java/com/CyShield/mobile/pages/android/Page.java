package com.CyShield.mobile.pages.android;

import io.appium.java_client.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;


public class Page {
    static protected AppiumDriver driver;
    protected WebDriverWait wait;

    public Page(AppiumDriver driver) {
        Page.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
    }

    protected void visibilityWait(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        driver.findElement(element).click();
    }

    public void clickElementByText(String text) {
        clickElement(By.xpath("//*[@text= '" + text + "']"));
    }

    public boolean checkElementIsSelected(By element) {
        visibilityWait(element);
        return driver.findElement(element).isSelected();
    }

}
