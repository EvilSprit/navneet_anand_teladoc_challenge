package Assistment;

import lombok.Getter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

/**
 * Test Base
 *
 * @author navneet
 */
@Getter
public class TestBase {

    ChromeDriver driver;

    /**
     * Test Suite Setup
     */
    @BeforeSuite
    public void testSuiteSetup() {
        System.out.println("Test Suite Setup");
        driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
    }

    @BeforeMethod
    public void testSetup(Method method) {
        System.out.println("Test Setup: " + method.getName());
    }

    /**
     * Test Suite Tear Down
     */
    @AfterSuite
    public void testSuiteTearDown() {
        System.out.println("Test Suite Tear Down");
        driver.quit();
    }
}
