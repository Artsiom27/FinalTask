package testCases;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProfilPage;
import pages.WebDriverSingletion;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CartTest {
    private WebDriver driver;
    private ProfilPage profilePage;
    private CartPage cartPage;
    private LoginTest loginTest;
    private LoginPage loginPage;
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static String USER_EMAIL;
    private static String PASSWD;

    @BeforeAll
    public void setUp() {
        driver = WebDriverSingletion.getInstance().openBrowser();
        driver.get(URL);
        loginPage = new LoginPage();
        loginTest = new LoginTest();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        USER_EMAIL = loginTest.getUserEmail();
        PASSWD = loginTest.getUserPasswd();
    }

    @Test
    void addToUserCart() {
        profilePage = loginPage.loginToAccount(USER_EMAIL, PASSWD);
        cartPage = profilePage.goToProducts();
        cartPage.addToCart();
        double totalPriseExpected = cartPage.getFirstPrise() + cartPage.getSecondPrise() + cartPage.getThirdPrise() + cartPage.getShippingPrise();
        assertEquals(totalPriseExpected, cartPage.getTotalPrise());
    }

    @AfterAll
    public void close() {
        driver.quit();
    }
}
