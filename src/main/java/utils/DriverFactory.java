package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static AppiumDriver driver;

    public static void setDriver(String lang, String locale) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.acceptInsecureCerts();
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:appPackage", PropertiesReader.getProperty("appPackage"));
        capabilities.setCapability("appium:appActivity", PropertiesReader.getProperty("appActivity"));
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:locale", locale.toUpperCase());
        capabilities.setCapability("appium:language", lang.toLowerCase());
        capabilities.setCapability("appium:disableIdLocatorAutocompletion", true);

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ElementHelper.driver = driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
