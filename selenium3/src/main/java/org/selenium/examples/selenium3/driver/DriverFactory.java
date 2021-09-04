package org.selenium.examples.selenium3.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.selenium.examples.selenium3.driver.manager.ChromeDriverManager;
import org.selenium.examples.selenium3.driver.manager.FirefoxDriverManager;
import org.selenium.examples.selenium3.driver.manager.RemoteChromeDriverManager;
import org.selenium.examples.selenium3.driver.manager.RemoteFirefoxDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.Optional;

/**
 * @author Karol Kuta-Orlowicz
 */
public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private final String HUB_URL = "http://192.168.1.12:4444/wd/hub/";

    public WebDriver getDriver() throws MalformedURLException {
        final String driverType = Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME");
        logger.info("Try get driver for browser type: " + driverType);
        return getDriver(driverType);
    }

    public WebDriver getDriver(String driverType) throws MalformedURLException {
        switch (DriverType.valueOf(driverType)) {
            case REMOTE_CHROME:
                return new RemoteChromeDriverManager(this.HUB_URL)
                        .setupLogPreferences()
                        .setFullWindowSize()
                        .setIgnoreCertErrors()
                        .getDriver();
            case REMOTE_FIREFOX:
                WebDriver remoteFirefoxDriver = new RemoteFirefoxDriverManager(this.HUB_URL)
                        .setIgnoreCertErrors()
                        .getDriver();
                remoteFirefoxDriver.manage().window().maximize();
                return remoteFirefoxDriver;
            case FIREFOX:
                WebDriver firefoxDriver = new FirefoxDriverManager()
                        .setIgnoreCertErrors()
                        .getDriver();
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;
            default:
                return new ChromeDriverManager()
                        .setFullWindowSize()
                        .setupLogPreferences()
                        .setIgnoreCertErrors()
                        .getDriver();
        }
    }

    public WebDriver getDriver(MutableCapabilities options) throws MalformedURLException {
        final String driverType = Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME");
        logger.info("Try get driver for browser type: " + driverType);
        return getDriver(driverType, options);
    }

    public WebDriver getDriver(String driverType, MutableCapabilities options) throws MalformedURLException {
        switch (DriverType.valueOf(driverType)) {
            case REMOTE_CHROME:
                return new RemoteChromeDriverManager(this.HUB_URL).getDriver(options);
            case REMOTE_FIREFOX:
                return new RemoteFirefoxDriverManager(this.HUB_URL).getDriver(options);
            case FIREFOX:
                return new FirefoxDriverManager().getDriver(options);
            default:
                return new ChromeDriverManager().getDriver(options);
        }
    }
}
