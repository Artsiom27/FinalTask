package test;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.WebDriverSingletion;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Listener implements TestWatcher, AfterAllCallback {
    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("browserOptions", String.valueOf(driverOptions()));
        Allure.addAttachment("screenshot for the failed test", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.addAttachment("data and time of a test", currentDataAndTime());
    }

    @Attachment(value = "driverOptions")
    protected DesiredCapabilities driverOptions() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(CapabilityType.VERSION, "89");
        capabilities.setCapability("platform", "win10");
        return capabilities;
    }

    @Attachment(value = "data and time of a test")
    protected String currentDataAndTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {

    }
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }
    @Override
    public void testSuccessful(ExtensionContext context) {

    }
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
    }
}