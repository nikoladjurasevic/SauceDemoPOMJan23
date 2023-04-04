package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.Strings;

public class BaseTest {

    public ChromeDriver openChromeDriver() {
        print("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        //ovo dole sluzi za setovanje dimenzija browsera
//        driver.manage().window().setSize(new Dimension(600,768));
        return driver;
    }


    public void loginUser(ChromeDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterTextInUserNameField(Strings.VALID_USERNAME);
        loginPage.enterTextInPasswordField(Strings.VALID_PASS);
        loginPage.clickLoginButton();

        assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "User is NOT logged in" +
                ". Current url : " + driver.getCurrentUrl() + " . Expected: " + Strings.INVENTORY_PAGE_URL;
    }




    //ovo sluzi samo za printanje texta u konzoli
    public static void print(String s) {
        System.out.println(s);
    }


    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }
}
