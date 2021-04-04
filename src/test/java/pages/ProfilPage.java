package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilPage {

    private static final By USERMENU = By.cssSelector(".account span");
    private static final By WISHLIST_OPEN_BUTTON = By.cssSelector(".lnk_wishlist");
    private static final By OPEN_DRESSES_BUTTON = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");

    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();

    public String getLoginTitle() {
        return driver.findElement(USERMENU).getText();
    }

    public WishlistPage goToWishlist() {
        driver.findElement(WISHLIST_OPEN_BUTTON).click();
        return new WishlistPage();
    }

    public CartPage goToProducts() {
        driver.findElement(OPEN_DRESSES_BUTTON).click();
        return new CartPage();
    }
}
