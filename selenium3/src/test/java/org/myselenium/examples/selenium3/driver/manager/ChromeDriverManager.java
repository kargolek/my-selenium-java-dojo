package org.myselenium.examples.selenium3.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public class ChromeDriverManager {

    final ChromeOptions chromeOptions = new ChromeOptions();

    public WebDriver getDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(this.chromeOptions);
    }

    public ChromeDriverManager setFullWindowSize() {
        this.chromeOptions.addArguments("--start-maximized");
        return this;
    }

    public ChromeDriverManager setIgnoreCertErrors() {
        this.chromeOptions.addArguments("--ignore-certificate-error");
        return this;
    }

    public ChromeDriverManager setHeadlessMode() {
        this.chromeOptions.addArguments("--headless");
        return this;
    }

    public ChromeDriverManager setDisabledGPU() {
        this.chromeOptions.addArguments("--disable-gpu");
        return this;
    }

    public ChromeDriverManager setWindowSize(int width, int height) {
        this.chromeOptions.addArguments(String.format("--window-size=%d,%d", width, height));
        return this;
    }


}
