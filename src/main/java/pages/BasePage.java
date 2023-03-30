package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        boolean isPresent = shoppingCartIcon.isDisplayed();
        return isPresent;
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
}
