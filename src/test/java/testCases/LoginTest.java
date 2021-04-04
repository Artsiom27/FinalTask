package testCases;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilPage;
import pages.WebDriverSingletion;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(Listener.class)

public class LoginTest {
    private LoginPage loginPage;
    private ProfilPage profilePage;
    private WebDriver driver;
    private static final String USER_EMAIL = "temancvik42@gmail.com";
    private static final String FIRSTNAME = "Artsiom";
    private static final String LASTNAME = "Tsvikevich";
    private static final String PASSWD = "123456789";
    private static final String CITY = "LA";
    private static final String ADDRESS = "Street";
    private static final String STATE = "California";
    private static final String POSTCODE = "32032";
    private static final String PHONE = "3202578";
    private static final String USER_NAME_EXPECTED = FIRSTNAME + " " + LASTNAME;
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final By SIGN_OUT_BUTTON = By.cssSelector("a.logout");

    @BeforeAll
    public void setUp() {
        driver = WebDriverSingletion.getInstance().openBrowser();
        driver.get(URL);
        loginPage = new LoginPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    void createAnAccountAndLoginTest() {
        loginPage.goToCreatingAnAccount(USER_EMAIL);
        profilePage = loginPage.registerAnAccount(FIRSTNAME, LASTNAME, PASSWD, ADDRESS, CITY, POSTCODE, STATE, PHONE);
        driver.findElement(SIGN_OUT_BUTTON).click();
        profilePage = loginPage.loginToAccount(USER_EMAIL, PASSWD);
        assertEquals(USER_NAME_EXPECTED, profilePage.getLoginTitle());
    }

    public String getUserEmail() {
        return USER_EMAIL;
    }

    public String getUserPasswd() {
        return PASSWD;
    }

    @AfterAll
    public void close() {
        driver.quit();
    }
}

