package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {

    //Webelements
    @FindBy (xpath = "//select")
    WebElement dropDownButton;

    @FindBy (xpath = "//*[@data-test = 'add-to-cart-sauce-labs-bike-light']")
    WebElement addToCartBikeLight;

    @FindBy (xpath = "//span[@class = 'shopping_cart_badge']")
    WebElement shoppingCartBadge;

    //konstruktor
    public InventoryPage(ChromeDriver driver) {
        super(driver);
        print("Inventory page");
        assert verifyURL(Strings.INVENTORY_PAGE_URL) : "Wrong URL";
    }

    //methods
    public void clickAddToCartBikeLight() {
        print("clickAddToCartBikeLight");
        addToCartBikeLight.click();
    }

    public String getNumberFromShoppingCartIcon() {
        print("getNumberFromShoppingCartIcon");
        return shoppingCartBadge.getText();
    }

    public void sortItemsByText(String sortType) {
        print("sortItemsByText ( " + sortType + " )");
        Select dropdown = new Select(dropDownButton);
        dropdown.selectByVisibleText(sortType);
    }

}
