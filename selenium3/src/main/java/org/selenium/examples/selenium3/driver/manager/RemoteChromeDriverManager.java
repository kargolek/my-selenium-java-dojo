package org.selenium.examples.selenium3.driver.manager;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Karol Kuta-Orlowicz
 */
public class RemoteChromeDriverManager extends ChromeDriverManager {

    private final String HUB_URL;

    public RemoteChromeDriverManager(String HUB_URL) {
        this.HUB_URL = HUB_URL;
    }

    @Override
    public WebDriver getDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL(this.HUB_URL), this.CHROME_OPTIONS);
    }

    @Override
    public WebDriver getDriver(MutableCapabilities options) throws MalformedURLException {
        ChromeOptions chromeOptions = (ChromeOptions) options;
        return new RemoteWebDriver(new URL(this.HUB_URL), chromeOptions);
    }
}
