package com.teladoc.page;

import com.teladoc.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Conformation Dialog Page.
 *
 * @author navneet
 */
public class ConformationDialogPage {

    private WebDriver driver;

    private ConformationDialogPage() {
        // private constructor
    }

    public ConformationDialogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn ng-scope ng-binding' and text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@class='btn ng-scope ng-binding btn-primary' and text()='OK']")
    private WebElement okButton;

    /**
     * Method to click on cancel button.
     */
    public void clickCancelButton() {
        new WaitUtils(this.driver).waitForElementToBePresent(cancelButton).click();
    }

    /**
     * Method to click on OK button.
     */
    public void clickOkButton() {
        new WaitUtils(this.driver).waitForElementToBePresent(okButton).click();
    }
}
