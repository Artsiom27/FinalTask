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

    public double getTotalPrise() {
        String priceTotal = driver.findElement(TOTAL_PRICE).getText();
        String[] split = priceTotal.split("[\\$]");
        String delimiter = "";
        String totalString = String.join(delimiter, split);
        double totalPrice = Double.parseDouble(totalString);
        return totalPrice;
    }

    public double getFirstPrise() {
        String priceFirst = driver.findElement(PRICE_OF_FIRST).getText();
        String[] splitFirst = priceFirst.split("[\\$]");
        String delimiterFirst = "";
        String stringFirst = String.join(delimiterFirst, splitFirst);
        double priseFirst = Double.parseDouble(stringFirst);
        return priseFirst;
    }

    public double getSecondPrise() {
        String priceSecond = driver.findElement(PRICE_OF_SECOND).getText();
        String[] splitSecond = priceSecond.split("[\\$]");
        String delimiterSecond = "";
        String stringSecond = String.join(delimiterSecond, splitSecond);
        double priseSecond = Double.parseDouble(stringSecond);
        return priseSecond;
    }

    public double getThirdPrise() {
        String priceThird = driver.findElement(PRICE_OF_THIRD).getText();
        String[] splitThird = priceThird.split("[\\$]");
        String delimiterThird = "";
        String stringThird = String.join(delimiterThird, splitThird);
        double priseThird = Double.parseDouble(stringThird);
        return priseThird;
    }

    public double getShippingPrise() {
        String priceShip = driver.findElement(PRICE_OF_SHIPPING).getText();
        String[] splitShip = priceShip.split("[\\$]");
        String delimiterShip = "";
        String stringShip = String.join(delimiterShip, splitShip);
        double priseShip = Double.parseDouble(stringShip);
        return priseShip;
    }
}
