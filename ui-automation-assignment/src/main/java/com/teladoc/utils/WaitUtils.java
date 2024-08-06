package com.teladoc.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Wait Utils.
 *
 * @author navneet
 */
public class WaitUtils {

    private WebDriverWait webDriverWait;

    private WaitUtils() {
        // private constructor
    }

    public WaitUtils(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Wait for element to be visible.
     *
     * @param webElement - WebElement
     * @return - boolean
     */
    public boolean waitForElementToBeVisible(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    }

    /**
     * Wait for element to be clickable.
     *
     * @param webElement - WebElement
     * @return - boolean
     */
    public boolean waitForElementToBeClickable(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).isEnabled();
    }

    /**
     * Wait for element to be present.
     *
     * @param webElement - WebElement
     * @return - WebElement
     */
    public WebElement waitForElementToBePresent(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
