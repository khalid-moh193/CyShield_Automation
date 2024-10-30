package com.CyShield.web.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void openURL(String url) {
        driver.navigate().to(url);
    }

    public void visibilityWait(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        highlightAndScreenshotElement(element);
    }

    protected void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        highlightAndScreenshotElement(element);
        element.click();
    }

    @Step("-Send Text")
    protected void sendText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.sendKeys(text);
        highlightAndScreenshotElement(element);
    }

    @Step("-get Page URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("-get Alert text")
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    @Step("-Check Element is displayed: {0}")
    public boolean checkElementIsDisplayed(By locator) {
        try {
            visibilityWait(locator);
            driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            System.out.println("Couldn't find element located by: " + locator);
            return false;
        }
        return true;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    private void highlightAndScreenshotElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid red'", element);
        saveScreenshotPNG();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
    }

}