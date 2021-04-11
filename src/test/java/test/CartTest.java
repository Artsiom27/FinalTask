package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WebDriverSingletion;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CartTest {
    private WebDriver driver;
    private ProfilePage profilePage;
    private CartPage cartPage;
    private LoginPage loginPage;

    @BeforeAll
    public void setUp() {
        driver = WebDriverSingletion.getInstance().openBrowser();
        loginPage = new LoginPage();
    }

    @Test
    void addToUserCart() {
        profilePage = loginPage.loginToAccount();
        cartPage = profilePage.goToProducts();
        cartPage.addToCart();
        double totalPriceExpected = cartPage.getFirstPrice() + cartPage.getSecondPrice() + cartPage.getThirdPrice() + cartPage.getShippingPrice();
        assertEquals(totalPriceExpected, cartPage.getTotalPriCe());
    }

    @AfterAll
    public void close() {
        driver = WebDriverSingletion.getInstance().closeBrowser();
    }
}
