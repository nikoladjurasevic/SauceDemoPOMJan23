package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    //mozete imate i atribru ChromeDriver
    ChromeDriver driver;

    //WebElements
    @FindBy (xpath = "//a[@class = 'shopping_cart_link']")
    WebElement shoppingCartIcon;

    @FindBy (xpath = "//div[contains(@class, 'burger-button')]")
    WebElement burgerMenuButton;

    @FindBy (xpath = "//a[text() = 'Twitter']")
    WebElement twitterButton;


    //Konstruktor
    public BasePage() {}

    public BasePage(ChromeDriver driver) {
        //ovde setujete da drajver iz testa bude i u klasi
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //metode

    /**
     * Clicks on a Shopping cart icon in upper right corner
     */
    public void clickShoppingCartIcon() {
        print("clickShoppingCartIcon");
        //nije lose imati i asertaciju pre neke akcije nad webelementom
        assert isShoppingCartIconPresent() : "Shopping cart is NOT present";
        shoppingCartIcon.click();
    }

    /**
     * Method checks if Shoppinc cart Icon is present in header
     * @return
     */
    public boolean isShoppingCartIconPresent() {
        print("isShoppingCartIconPresent()");
        return isElementPresent(shoppingCartIcon);
    }


    //ovo sluzi samo za printanje texta u konzoli
    public static void print(String s) {
        System.out.println(s);
    }



    public boolean verifyURL(String expectedUrl) {
        print("verifyURL ( " + expectedUrl + " )");
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(expectedUrl);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }

    public boolean isElementPresent(WebElement element) {
        try{
            print("isElementPresent()");
            boolean isPresent = element.isDisplayed();
            return isPresent;
        }catch (Exception e) {
            return false;
        }
    }

    //ovo cemo koristiti za elemente stranice gde treba da se skroluje do njih
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" ,element);
    }

    public void waitForElement(WebElement element) {
        //ovde najcesce stavljam wait zato sto ga koristim da sacekam da se webelementi pojave a oni su u Page klasama
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
