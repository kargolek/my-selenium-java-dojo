package org.selenium.examples.selenium3.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.net.MalformedURLException;
import java.util.logging.Level;

/**
 * @author Karol Kuta-Orlowicz
 */
public class FirefoxDriverManager implements DriverManagerImpl {

    final FirefoxOptions FIREFOX_OPTIONS = new FirefoxOptions();

    public WebDriver getDriver() throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(this.FIREFOX_OPTIONS);
    }

    @Override
    public WebDriver getDriver(MutableCapabilities mutableCapabilities) throws MalformedURLException {
        FirefoxOptions firefoxOptions = (FirefoxOptions) mutableCapabilities;
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    public FirefoxDriverManager setIgnoreCertErrors() {
        this.FIREFOX_OPTIONS.addArguments("--ignore-certificate-error");
        return this;
    }

    @Override
    public FirefoxDriverManager setHeadlessMode() {
        this.FIREFOX_OPTIONS.addArguments("--headless");
        return this;
    }
}
