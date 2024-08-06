package assignment;

import com.teladoc.constants.CustomerType;
import com.teladoc.models.UserDetails;
import com.teladoc.page.AddUserPage;
import com.teladoc.page.ConformationDialogPage;
import com.teladoc.page.UserPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * UI Automation test.
 *
 * @author navneet
 */
public class UIAutomationTest extends TestBase {

    private final UserDetails userDetails = UserDetails.builder()
            .firstName("Navneet")
            .lastName("Anand")
            .userName(String.valueOf(System.currentTimeMillis()))
            .password("novak123")
            .customer(CustomerType.COMPANY_AAA)
            .role("Admin")
            .email("navneet@teladoc.com")
            .cellPhone("1234567890")
            .build();

    /**
     * Test to validate the addition of new user
     */
    @Test(priority = 1)
    public void testValidateAddNewUser() {
        UserPage userPage = new UserPage(driver);
        AddUserPage addUserPage = new AddUserPage(driver);
        userPage.clickAddUserButton();
        addUserPage.fillUserDetails(userDetails);
        addUserPage.clickSaveButton();
        Assert.assertTrue(userPage.isUserPresentInTheList(userDetails.getUserName()));
    }

    /**
     * Test to validate the deletion of user
     */
    @Test(priority = 2)
    public void testValidateDeleteUser() {
        UserPage userPage = new UserPage(driver);
        ConformationDialogPage conformationDialogPage = new ConformationDialogPage(driver);
        userPage.clickDeleteUserButton(userDetails.getUserName());
        conformationDialogPage.clickOkButton();
        Assert.assertFalse(userPage.isUserPresentInTheList(userDetails.getUserName()));
    }
}
