package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private static final By OPEN_DRESSES_BUTTON = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    private static final By PRODUCT_DRESS2_CHOICE = By.cssSelector("img[src=\"http://automationpractice.com/img/p/1/0/10-home_default.jpg\"]");
    private static final By PRODUCT_DRESS_CHOICE = By.cssSelector("img[src=\"http://automationpractice.com/img/p/1/6/16-home_default.jpg\"]");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("p button[name=\"Submit\"]");
    private static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("span[title=\"Continue shopping\"]");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("a[title=\"Proceed to checkout\"]");
    private static final By TOTAL_PRICE = By.cssSelector("span[id=\"total_price\"]");
    private static final By PRODUCT_DRESS3_CHOICE = By.cssSelector("img[src=\"http://automationpractice.com/img/p/2/0/20-home_default.jpg\"]");
    private static final By PRICE_OF_FIRST = By.cssSelector("tbody>tr:nth-child(1)>td[class=\"cart_total\"]>span");
    private static final By PRICE_OF_SECOND = By.cssSelector("tbody>tr:nth-child(2)>td[class=\"cart_total\"]>span");
    private static final By PRICE_OF_THIRD = By.cssSelector("tbody>tr:nth-child(3)>td[class=\"cart_total\"]>span");
    private static final By PRICE_OF_SHIPPING = By.cssSelector("#total_shipping");

    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();

    public CartPage addToCart() {
        driver.findElement(PRODUCT_DRESS_CHOICE).click();
        driver.findElement(ADD_TO_CART_BUTTON).click();
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        driver.findElement(OPEN_DRESSES_BUTTON).click();
        driver.findElement(PRODUCT_DRESS3_CHOICE).click();
        driver.findElement(ADD_TO_CART_BUTTON).click();
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        driver.findElement(OPEN_DRESSES_BUTTON).click();
        driver.findElement(PRODUCT_DRESS2_CHOICE).click();
        driver.findElement(ADD_TO_CART_BUTTON).click();
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
        return new CartPage();
    }

    public double getShippingPrice() {
        return getPrice(PRICE_OF_SHIPPING);
    }

    public double getThirdPrice() {
        return getPrice(PRICE_OF_THIRD);
    }

    public double getSecondPrice() {
        return getPrice(PRICE_OF_SECOND);
    }

    public double getFirstPrice() {
        return getPrice(PRICE_OF_FIRST);
    }

    public double getTotalPriCe() {
        return getPrice(TOTAL_PRICE);
    }

    private double getPrice(By price) {
        String priceToSplit = driver.findElement(price).getText();
        String[] split = priceToSplit.split("[\\$]");
        String delimiter = "";
        String priceString = String.join(delimiter, split);
        return Double.parseDouble(priceString);
    }
}
