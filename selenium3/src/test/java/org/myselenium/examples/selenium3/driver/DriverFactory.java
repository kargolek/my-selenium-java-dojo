package org.myselenium.examples.selenium3.driver;

import org.myselenium.examples.selenium3.driver.manager.ChromeDriverManager;
import org.myselenium.examples.selenium3.driver.manager.FirefoxDriverManager;
import org.myselenium.examples.selenium3.driver.manager.RemoteChromeDriverManager;
import org.myselenium.examples.selenium3.driver.manager.RemoteFirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Optional;

public class DriverFactory {

    public static WebDriver getDriver() throws MalformedURLException {
        final String isEnvCI = Optional.ofNullable(System.getenv("CI")).orElse("false");
        final String driverType = Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME");

        return isEnvCI.equalsIgnoreCase("true")
                ? getRemoteDriver(driverType) : getLocalDriver(driverType);
    }

    private static WebDriver getRemoteDriver(String type) throws MalformedURLException {
        if ("FIREFOX".equalsIgnoreCase(type)) {
            return getDriver(DriverType.REMOTE_FIREFOX);
        }

        return getDriver(DriverType.REMOTE_CHROME);
    }

    private static WebDriver getLocalDriver(String type) throws MalformedURLException {
        if ("FIREFOX".equalsIgnoreCase(type)) {
            return getDriver(DriverType.FIREFOX);
        }

        return getDriver(DriverType.CHROME);
    }

    public static WebDriver getDriver(DriverType driverType) throws MalformedURLException {
        switch (driverType) {
            case REMOTE_CHROME:
                return new RemoteChromeDriverManager()
                        .setFullWindowSize()
                        .setIgnoreCertErrors()
                        .getDriver();
            case REMOTE_FIREFOX:
                WebDriver remoteFirefoxDriver = new RemoteFirefoxDriverManager()
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
}
