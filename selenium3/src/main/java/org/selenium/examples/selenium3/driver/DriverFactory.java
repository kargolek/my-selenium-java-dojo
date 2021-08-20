package org.selenium.examples.selenium3.driver;

import org.selenium.examples.selenium3.driver.manager.ChromeDriverManager;
import org.selenium.examples.selenium3.driver.manager.FirefoxDriverManager;
import org.selenium.examples.selenium3.driver.manager.RemoteChromeDriverManager;
import org.selenium.examples.selenium3.driver.manager.RemoteFirefoxDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Optional;
/**
 * @author Karol Kuta-Orlowicz
 */
public class DriverFactory {

    private final String HUB_URL = "http://192.168.1.12:4444/wd/hub/";

    public WebDriver getDriver() throws MalformedURLException {
        final String driverType = Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME");
        return getDriver(driverType);
    }

    public WebDriver getDriver(String driverType) throws MalformedURLException {
        switch (DriverType.valueOf(driverType)) {
            case REMOTE_CHROME:
                return new RemoteChromeDriverManager(this.HUB_URL)
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
                        .setIgnoreCertErrors()
                        .getDriver();
        }
    }

    public WebDriver getDriver(MutableCapabilities options) throws MalformedURLException {
        final String driverType = Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME");
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
