package testCases;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilPage;
import pages.WebDriverSingletion;
import pages.WishlistPage;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(Listener.class)

public class WishlistTest {
    private LoginPage loginPage;
    private ProfilPage profilePage;
    private LoginTest loginTest;
    private WishlistPage wishlistPage;
    private WebDriver driver;
    private static String USER_EMAIL;
    private static String PASSWD;
    private static final String AUTO_WISHLIST_NAME_EXPECTED = "My wishlist";
    private static final String PRODUCT_NAME_EXPECTED = "Printed Chiffon Dress\n" + "S, Yellow";
    private static final String USER_WISHLIST_NAME_EXPECTED = "Dresses";
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @BeforeAll
    public void setUp() {
        driver = WebDriverSingletion.getInstance().openBrowser();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage();
        loginTest = new LoginTest();
        USER_EMAIL = loginTest.getUserEmail();
        PASSWD = loginTest.getUserPasswd();
    }

    @Test
    @Order(1)
    void checkWishlist() {
        profilePage = loginPage.loginToAccount(USER_EMAIL, PASSWD);
        wishlistPage = profilePage.goToWishlist();
        assertTrue(wishlistPage.isWishlistEmpty());
    }

    @Test
    @Order(2)
    void addToAutoWishlist() {
        wishlistPage.addToAutocreatedWishlist();
        assertEquals(AUTO_WISHLIST_NAME_EXPECTED, wishlistPage.getAutoWishlistTitle());
        assertEquals(PRODUCT_NAME_EXPECTED, wishlistPage.getWishlistProducts());
    }

    @Test
    @Order(3)
    void addToUserWishlist() {
        wishlistPage.deleteAutoWishlist();
        wishlistPage.addToUserWishlist("Dresses");
        assertEquals(USER_WISHLIST_NAME_EXPECTED, wishlistPage.getAutoWishlistTitle());
        assertEquals(PRODUCT_NAME_EXPECTED, wishlistPage.getWishlistProducts());
    }

    @AfterAll
    public void close() {
        driver.quit();
    }
}

