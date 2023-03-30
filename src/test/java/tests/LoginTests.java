package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;

public class LoginTests extends BaseTest {


    /**
     * Login with valid credentials
     * Steps:
     * 1. Enter valid username
     * 2. Enter valid password
     * 3. Click Login button
     *
     * Expected result:
     * Verify that user is logged in
     */
    @Test
    public void loginWithValidCreds() {

        ChromeDriver driver = openChromeDriver();
        //pisemo testove u try/finally blokovima
        try {
            LoginPage loginPage = new LoginPage(driver);

            print("1. Enter valid username");
            loginPage.enterTextInUserNameField(Strings.VALID_USERNAME);
            print("2. Enter valid password");
            loginPage.enterTextInPasswordField(Strings.VALID_PASS);
            print("3. Click Login button");
            loginPage.clickLoginButton();

            print("4. Verify that user is on Products page");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.INVENTORY_PAGE_URL) : "User is on a wrong page. Expected: " +
                   "" + Strings.INVENTORY_PAGE_URL + " Actual " + actualUrl ;
        }finally {
            driver.quit();
        }

    }
}
