package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingletion {

    private static WebDriverSingletion instance = null;
    private WebDriver driver = new ChromeDriver();

    private WebDriverSingletion() {
    }

    public static WebDriverSingletion getInstance() {
        if (instance == null) {
            instance = new WebDriverSingletion();
        }
        return instance;
    }

    public WebDriver openBrowser() {
        return driver;
    }
}