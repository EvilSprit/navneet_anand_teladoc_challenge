package com.teladoc.page;

import com.teladoc.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * User Page
 *
 * @author navneet
 */
public class UserPage {

    private WebDriver driver;
    private static final String USER_NAME = "//td[@class='smart-table-data-cell' and text()='<USER_NAME>']";

    private UserPage() {
        // private constructor
    }

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn-link pull-right' and @type='add']")
    private WebElement addUserButton;

    /**
     * Method to click on add user button.
     */
    public void clickAddUserButton() {
        new WaitUtils(driver).waitForElementToBePresent(addUserButton).click();
    }

    /**
     * Method to check if user is present in the list.
     *
     * @param userName - String
     * @return - boolean
     */
    public boolean isUserPresentInTheList(String userName) {
        try {
            return new WaitUtils(driver).waitForElementToBeVisible(driver.findElement(By.xpath(USER_NAME.replace("<USER_NAME>", userName))));
        } catch (Exception e) {
            System.out.println("User is not present in the list.");
            return false;
        }
    }

    /**
     * Method to click on delete user button.
     *
     * @param userName - String
     */
    public void clickDeleteUserButton(String userName) {
        new WaitUtils(driver).waitForElementToBePresent(driver.findElement(By.xpath(USER_NAME.replace("<USER_NAME>", userName) + "/.."))
                .findElement(By.xpath("//button[@class='btn btn-link' and @ng-click='delUser()']"))).click();
    }
}
