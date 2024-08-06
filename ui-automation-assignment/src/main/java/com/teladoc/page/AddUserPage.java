package com.teladoc.page;

import com.teladoc.constants.CustomerType;
import com.teladoc.models.UserDetails;
import com.teladoc.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Add User Page.
 *
 * @author navneet
 */
public class AddUserPage {

    private WebDriver driver;

    private AddUserPage() {
        // private constructor
    }

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='ng-pristine ng-invalid ng-invalid-required' and @name='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@class='ng-pristine ng-valid' and @name='LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@class='ng-pristine ng-invalid ng-invalid-required' and @name='UserName']")
    private WebElement userName;

    @FindBy(xpath = "//input[@class='ng-pristine ng-valid' and @name='Password']")
    private WebElement password;

    @FindBy(xpath = "//label[@class='radio ng-scope ng-binding' and text()='Company AAA']/input")
    private WebElement companyAAA;

    @FindBy(xpath = "//label[@class='radio ng-scope ng-binding' and text()='Company BBB']/input")
    private WebElement companyBBB;

    @FindBy(xpath = "//select[@name='RoleId']")
    private WebElement roleDropDown;

    @FindBy(xpath = "//input[@class='ng-pristine ng-valid ng-valid-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@class='ng-pristine ng-invalid ng-invalid-required' and @name='Mobilephone']")
    private WebElement cellPhone;

    @FindBy(xpath = "//button[@class='btn btn-danger' and text()='Close']")
    private WebElement closeButton;

    @FindBy(xpath = "//button[@class='btn btn-success' and text()='Save']")
    private WebElement saveButton;

    /**
     * Fill user details.
     *
     * @param userDetails - UserDetails
     */
    public void fillUserDetails(UserDetails userDetails) {
        new WaitUtils(this.driver).waitForElementToBePresent(this.firstName).sendKeys(userDetails.getFirstName());
        new WaitUtils(this.driver).waitForElementToBePresent(this.lastName).sendKeys(userDetails.getLastName());
        new WaitUtils(this.driver).waitForElementToBePresent(this.userName).sendKeys(userDetails.getUserName());
        new WaitUtils(this.driver).waitForElementToBePresent(this.password).sendKeys(userDetails.getPassword());

        selectRadioButton(userDetails.getCustomer());

        roleDropDown.sendKeys(userDetails.getRole());

        new WaitUtils(this.driver).waitForElementToBePresent(this.email).sendKeys(userDetails.getEmail());
        new WaitUtils(this.driver).waitForElementToBePresent(this.cellPhone).sendKeys(userDetails.getCellPhone());
    }

    /**
     * Click Save Button.
     */
    public void clickSaveButton() {
        new WaitUtils(this.driver).waitForElementToBePresent(saveButton).click();
    }

    /**
     * Click Close Button.
     */
    public void clickCloseButton() {
        new WaitUtils(this.driver).waitForElementToBePresent(closeButton).click();
    }

    /**
     * Select Radio Button.
     *
     * @param customerType - CustomerType
     */
    private void selectRadioButton(CustomerType customerType) {
        switch (customerType) {
            case COMPANY_AAA -> new WaitUtils(this.driver).waitForElementToBePresent(this.companyAAA).click();
            case COMPANY_BBB -> new WaitUtils(this.driver).waitForElementToBePresent(this.companyBBB).click();
        }
    }

    /**
     * Select Role.
     *
     * @param role - Role
     */
    private void selectRole(String role) {
        new Select(new WaitUtils(this.driver).waitForElementToBePresent(this.roleDropDown)).selectByVisibleText(role);
    }
}
