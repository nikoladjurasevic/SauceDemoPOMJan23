package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.Strings;

public class SortingTests extends BaseTest{



    @Test
    public void testSortByPriceAsc() {
        print("testSortByPriceAsc");
        ChromeDriver driver = openChromeDriver();
        try {
            loginUser(driver);

            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.sortItemsByText(Strings.SORT_BY_PRICE_ASC);

            //ovde dodajte deo gde proveravate da li si itemi sortirani

        }finally {
            driver.quit();
        }
    }


}
