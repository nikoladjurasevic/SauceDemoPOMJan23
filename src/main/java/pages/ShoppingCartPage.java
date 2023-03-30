package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    //webelements
    @FindBy (xpath = "//*[data-test = 'continue-shopping']")
    WebElement continueShoppingButton;

    @FindBy (xpath = "//*[data-test = 'checkout']")
    WebElement checkoutButton;

    @FindBy (xpath = "//div[@class = 'cart_item']")
    WebElement cartItem;

    //konstuktor
    public ShoppingCartPage(ChromeDriver driver) {
        super(driver);
        print("ShoppingCartPage");
        assert verifyURL(Strings.SHOPPING_CART_URL) : "Wrong URL";
    }

    public String getFirstItemName() {
        print("getFirstItemName");
        WebElement itemName = cartItem.findElement(By.xpath(".//div[@class = 'inventory_item_name']"));
        return itemName.getText();
    }

}
