package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    private static final By USERMENU = By.cssSelector(".account span");
    private static final By WISHLIST_OPEN_BUTTON = By.cssSelector(".lnk_wishlist");
    private static final By SIGN_OUT_BUTTON = By.name("nofollow");
    private static final By PRODUCT = By.cssSelector("li>a[href=\"http://automationpractice.com/index.php?id_product=7&controller=product\"]");
    private static final By ADD_TO_WISHLIST__BUTTON = By.cssSelector("#wishlist_button");
    private static final By CLOSE_MESSAGE_BUTTON = By.cssSelector("a[title=\"Close\"]");
    private static final By ACCOUNT_OPEN_BUTTON = By.cssSelector(".account");
    private static final By WISHLIST_NAME = By.cssSelector("td:nth-child(1) > a");
    private static final By NEW_WISHLIST_NAME_INPUT = By.name("name");
    private static final By SUBMIT_WISHLIST_BUTTON = By.name("submitWishlist");
    private static final By PRODUCTS_AT_AUTOWISHLIST_BUTTON = By.cssSelector("td:nth-child(5) > a");
    private static final By PRODUCT_AT_WISHLIST_NAME = By.cssSelector("#s_title");
    private static final By PRODUCTS_AT_USERWISHLIST_BUTTON = By.cssSelector("tbody tr:nth-child(1) td:nth-child(5) > a");
    private static final By AUTOWISHLIST_DELETE = By.cssSelector(".icon-remove");

    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();


    public WishlistPage addToAutocreatedWishlist() {
        driver.findElement(PRODUCT).click();
        driver.findElement(ADD_TO_WISHLIST__BUTTON).click();
        driver.findElement(CLOSE_MESSAGE_BUTTON).click();
        driver.findElement(ACCOUNT_OPEN_BUTTON).click();
        driver.findElement(WISHLIST_OPEN_BUTTON).click();
        driver.findElement(PRODUCTS_AT_AUTOWISHLIST_BUTTON).click();
        return new WishlistPage();
    }

    public WishlistPage addToUserWishlist(String wishlistName) {
        driver.findElement(WISHLIST_OPEN_BUTTON).click();
        driver.findElement(NEW_WISHLIST_NAME_INPUT).sendKeys(wishlistName);
        driver.findElement(SUBMIT_WISHLIST_BUTTON).click();
        driver.findElement(PRODUCT).click();
        driver.findElement(ADD_TO_WISHLIST__BUTTON).click();
        driver.findElement(CLOSE_MESSAGE_BUTTON).click();
        driver.findElement(ACCOUNT_OPEN_BUTTON).click();
        driver.findElement(WISHLIST_OPEN_BUTTON).click();
        driver.findElement(PRODUCTS_AT_USERWISHLIST_BUTTON).click();
        return new WishlistPage();
    }

    public String getAutoWishlistTitle() {
        return driver.findElement(WISHLIST_NAME).getText();
    }

    public String getWishlistProducts() {
        return driver.findElement(PRODUCT_AT_WISHLIST_NAME).getText();
    }
    public WishlistPage deleteAutoWishlist() {
        driver.findElement(AUTOWISHLIST_DELETE).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
         return new WishlistPage();
    }

    public boolean isWishlistEmpty() {
        driver.findElement(WISHLIST_OPEN_BUTTON).click();
        return driver.findElements(PRODUCT_AT_WISHLIST_NAME).isEmpty();
    }
}
