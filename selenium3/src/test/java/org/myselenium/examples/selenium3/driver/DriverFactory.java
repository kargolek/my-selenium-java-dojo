package org.myselenium.examples.selenium3.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    public static WebDriver getDriver(DriverType driverType) throws MalformedURLException {

        switch (driverType) {
            case REMOTE:
                return new RemoteDriverManager()
                        .setFullWindowSize()
                        .getDriver();
            default:
                return new ChromeDriverManager()
                        .setFullWindowSize()
                        .setHeadlessMode()
                        .setIgnoreCertErrors()
                        .setDisabledGPU()
                        .getDriver();
        }
    }

    public static WebDriver getDriver() throws MalformedURLException {
        return System.getenv("CI").equals("true") ? getDriver(DriverType.REMOTE) : getDriver(DriverType.CHROME);
    }
}
