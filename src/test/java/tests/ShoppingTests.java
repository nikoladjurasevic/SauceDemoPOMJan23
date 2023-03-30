package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.ShoppingCartPage;
import pages.Strings;

public class ShoppingTests extends BaseTest{


    /**
     * Add one item
     * Steps:
     * 1. Login into Sauce demo
     * 2. Click on one item from inventory
     * 3. Click on shopping cart
     *
     * Expected result:
     * 2. Verify that the icon of shopping cart shows 1
     * 3. Verify that item is listed in shopping cart page
     */
    @Test
    public void testAddOneItemToCart() {
        print("testAddOneItemToCart");
        ChromeDriver driver = openChromeDriver();
        try {

            print("1. Login into Sauce demo");
            loginUser(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on one item from inventory");
            inventoryPage.clickAddToCartBikeLight();

            print("2. Verify that the icon of shopping cart shows 1");
            String actualNumber = inventoryPage.getNumberFromShoppingCartIcon();
            assert actualNumber.equals("1") : "Wrong number is shopping cart" +
                    ". Expected: 1 . Actual: " + actualNumber;

            print("3. Click on shopping cart");
            inventoryPage.clickShoppingCartIcon();
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

            print("3. Verify that item is listed in shopping cart page");
            String actualItemName = shoppingCartPage.getFirstItemName();
            assert actualItemName.contains(Strings.BIKE_LIGHT) : "Wrong item. Expected: " + Strings.BIKE_LIGHT +
                    ". Actual " + actualItemName;

        }finally {
            driver.quit();
        }

    }

}
