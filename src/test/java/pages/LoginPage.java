package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();
    private static final By USER_EMAIL_INPUT = By.cssSelector("#email_create");
    private static final By CREATE_BUTTON = By.cssSelector("button[name=SubmitCreate]");
    private static final By FIRSTNAME_INPUT = By.name("customer_firstname");
    private static final By LASTNAME_INPUT = By.name("customer_lastname");
    private static final By PASSWD_INPUT = By.name("passwd");
    private static final By ADDRESS_INPUT = By.name("address1");
    private static final By CITY_INPUT = By.name("city");
    private static final By POSTCODE_INPUT = By.name("postcode");
    private static final By STATE_INPUT = By.name("id_state");
    private static final By PHONE_INPUT = By.name("phone_mobile");
    private static final By REGISTER_BUTTON = By.cssSelector("button[name=submitAccount]");
    private static final By ACCOUNT_EMAIL = By.name("email");
    private static final By ACCOUNT_PASSWORD = By.name("passwd");
    private static final By SIGN_IN_BUTTON = By.cssSelector("button[name=SubmitLogin]");


    public void goToCreatingAnAccount(String email) {
        driver.findElement(USER_EMAIL_INPUT).sendKeys(email);
        driver.findElement(CREATE_BUTTON).click();
    }

    public ProfilPage registerAnAccount(String firstname, String lastname, String passwd, String address, String city, String postcode, String state, String phone) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        driver.findElement(PASSWD_INPUT).sendKeys(passwd);
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
        driver.findElement(CITY_INPUT).sendKeys(city);
        driver.findElement(POSTCODE_INPUT).sendKeys(postcode);
        Select dropdownStates = new Select(driver.findElement(STATE_INPUT));
        dropdownStates.selectByVisibleText(state);
        driver.findElement(PHONE_INPUT).sendKeys(phone);
        driver.findElement(REGISTER_BUTTON).click();
        return new ProfilPage();
    }

    public ProfilPage loginToAccount(String email, String passwd) {
        driver.findElement(ACCOUNT_EMAIL).sendKeys(email);
        driver.findElement(ACCOUNT_PASSWORD).sendKeys(passwd);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new ProfilPage();
    }

}
