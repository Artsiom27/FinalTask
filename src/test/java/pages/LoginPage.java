package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    AccountModel accountModel = new AccountModel();
    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();
    private static final By USER_EMAIL_INPUT = By.cssSelector("#email_create");
    private static final By CREATE_BUTTON = By.cssSelector("button[name=SubmitCreate]");
    private static final By ACCOUNT_EMAIL = By.name("email");
    private static final By ACCOUNT_PASSWORD = By.name("passwd");
    private static final By SIGN_IN_BUTTON = By.cssSelector("button[name=SubmitLogin]");

    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final String USER_EMAIL = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";

    public LoginPage() {
        driver.get(URL);
    }

    public void goToCreatingAnAccount() {
        driver.findElement(USER_EMAIL_INPUT).sendKeys(USER_EMAIL);
        driver.findElement(CREATE_BUTTON).click();
    }

    public ProfilePage loginToAccount() {
        driver.findElement(ACCOUNT_EMAIL).sendKeys(USER_EMAIL);
        driver.findElement(ACCOUNT_PASSWORD).sendKeys(accountModel.getUserPasswd());
        driver.findElement(SIGN_IN_BUTTON).click();
        return new ProfilePage();
    }
}
