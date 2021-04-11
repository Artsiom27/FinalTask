package pages;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverSingletion {

    private static WebDriverSingletion instance = null;
    private WebDriver driver;

    private WebDriverSingletion() {
    }

    public static WebDriverSingletion getInstance() {
        if (instance == null) {
            instance = new WebDriverSingletion();
        }
        return instance;
    }

    public WebDriver openBrowser() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver openRemoteGridBrowser(String URL) throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(URL), desiredCapabilities);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver closeBrowser() {
        driver.quit();
        driver = null;
        return driver;
    }
}