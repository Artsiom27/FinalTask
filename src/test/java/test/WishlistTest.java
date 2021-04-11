package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(Listener.class)

public class WishlistTest {
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private WishlistPage wishlistPage;
    private AccountModel accountModel;
    private WebDriver driver;
    private static final String AUTO_WISHLIST_NAME_EXPECTED = "My wishlist";
    private static final String PRODUCT_NAME_EXPECTED = "Printed Chiffon Dress\n" + "S, Yellow";
    private static final String USER_WISHLIST_NAME_EXPECTED = "Dresses";

    @BeforeAll
    public void setUp() {
        driver = WebDriverSingletion.getInstance().openBrowser();
        loginPage = new LoginPage();
        accountModel = new AccountModel();
    }

    @Test
    @Order(1)
    void checkWishlist() {
        profilePage = loginPage.loginToAccount();
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
        driver = WebDriverSingletion.getInstance().closeBrowser();
    }
}

