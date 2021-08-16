package org.myselenium.examples.selenium3.driver.manager;

import org.myselenium.examples.selenium3.driver.manager.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteChromeDriverManager extends ChromeDriverManager {

    @Override
    public WebDriver getDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://192.168.1.12:4444/wd/hub/"), this.chromeOptions);
    }
}
