package org.myselenium.examples.selenium3.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;

public class FirefoxDriverManager {

    final FirefoxOptions firefoxOptions = new FirefoxOptions();

    public WebDriver getDriver() throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(this.firefoxOptions);
    }

    public FirefoxDriverManager setIgnoreCertErrors() {
        this.firefoxOptions.addArguments("--ignore-certificate-error");
        return this;
    }

    public FirefoxDriverManager setHeadlessMode() {
        this.firefoxOptions.addArguments("--headless");
        return this;
    }

}
