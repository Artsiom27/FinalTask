package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class AccountModel {
    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();

    private static final By FIRSTNAME_INPUT = By.name("customer_firstname");
    private static final By LASTNAME_INPUT = By.name("customer_lastname");
    private static final By PASSWD_INPUT = By.name("passwd");
    private static final By ADDRESS_INPUT = By.name("address1");
    private static final By CITY_INPUT = By.name("city");
    private static final By POSTCODE_INPUT = By.name("postcode");
    private static final By STATE_INPUT = By.name("id_state");
    private static final By PHONE_INPUT = By.name("phone_mobile");
    private static final By REGISTER_BUTTON = By.cssSelector("button[name=submitAccount]");

    private static final String FIRSTNAME = RandomStringUtils.randomAlphabetic(8);
    private static final String LASTNAME = RandomStringUtils.randomAlphabetic(8);
    private static final String PASSWD = getUserRandomPasswd();


    public ProfilePage registerAnAccount() {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(FIRSTNAME);
        driver.findElement(LASTNAME_INPUT).sendKeys(LASTNAME);
        driver.findElement(PASSWD_INPUT).sendKeys(PASSWD);
        driver.findElement(ADDRESS_INPUT).sendKeys(randomString());
        driver.findElement(CITY_INPUT).sendKeys(randomString());
        driver.findElement(POSTCODE_INPUT).sendKeys(randomInt());
        Select dropdownStates = new Select(driver.findElement(STATE_INPUT));
        dropdownStates.selectByVisibleText("California");
        driver.findElement(PHONE_INPUT).sendKeys(randomInt());
        driver.findElement(REGISTER_BUTTON).click();
        return new ProfilePage();
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String randomInt() {
        Random rand = new Random();
        int min = 10000;
        int max = 99999;
        int generatedInt = rand.nextInt(max - min) + min;
        return String.valueOf((generatedInt));
    }

    public String getExpectedProfile() {
        return FIRSTNAME + " " + LASTNAME;
    }

    public String getUserPasswd() {
        return PASSWD;
    }

    public static String getUserRandomPasswd() {
        Random rand = new Random();
        int min = 10000;
        int max = 999999;
        int generatedInt = rand.nextInt(max - min) + min;
        return String.valueOf((generatedInt));
    }
}
