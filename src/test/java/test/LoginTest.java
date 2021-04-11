package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.AccountModel;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WebDriverSingletion;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(Listener.class)

public class LoginTest {
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private AccountModel accountModel;
    private WebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = WebDriverSingletion.getInstance().openBrowser();
        loginPage = new LoginPage();
        accountModel = new AccountModel();
    }

    @Test
    void createAnAccountAndLoginTest() {
        loginPage.goToCreatingAnAccount();
        profilePage = accountModel.registerAnAccount();
        loginPage = profilePage.logOut();
        profilePage = loginPage.loginToAccount();
        assertEquals(accountModel.getExpectedProfile(), profilePage.getLoginTitle());
    }

    @AfterAll
    public void close() {
        driver = WebDriverSingletion.getInstance().closeBrowser();
    }
}

