package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    ChromeDriver driver;

    //webelementi
    @FindBy (xpath = "//input[@data-test='username']")
    WebElement userNameField;

    @FindBy (xpath = "//input[@data-test='password']")
    WebElement passwordField;

    @FindBy (xpath = "//input[@data-test='login-button']")
    WebElement loginButton;

    //konstruktor
    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        driver.get(Strings.LOGIN_PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    //metode nad webelementima

    public void enterTextInUserNameField(String text) {
        userNameField.click();
        userNameField.sendKeys(text);
    }

    public void enterTextInPasswordField(String text) {
        passwordField.click();
        passwordField.sendKeys(text);
    }

    public void clickLoginButton() {
        loginButton.click();
    }



}
