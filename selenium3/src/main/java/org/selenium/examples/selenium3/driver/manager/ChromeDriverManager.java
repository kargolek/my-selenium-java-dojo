package org.selenium.examples.selenium3.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;
import java.util.logging.Level;

/**
 * @author Karol Kuta-Orlowicz
 */
public class ChromeDriverManager implements DriverManagerImpl {

    final ChromeOptions CHROME_OPTIONS = new ChromeOptions();

    public WebDriver getDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(this.CHROME_OPTIONS);
    }

    @Override
    public WebDriver getDriver(MutableCapabilities capabilities) throws MalformedURLException {
        ChromeOptions chromeOptions = (ChromeOptions) capabilities;
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    public ChromeDriverManager setFullWindowSize() {
        this.CHROME_OPTIONS.addArguments("--start-maximized");
        return this;
    }

    public ChromeDriverManager setIgnoreCertErrors() {
        this.CHROME_OPTIONS.addArguments("--ignore-certificate-error");
        return this;
    }

    public ChromeDriverManager setHeadlessMode() {
        this.CHROME_OPTIONS.addArguments("--headless");
        return this;
    }

    public ChromeDriverManager setupLogPreferences() {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        logPrefs.enable(LogType.PROFILER, Level.ALL);
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.CLIENT, Level.ALL);
        logPrefs.enable(LogType.DRIVER, Level.ALL);
        logPrefs.enable(LogType.SERVER, Level.ALL);
        this.CHROME_OPTIONS.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return this;
    }

    public ChromeDriverManager setDisabledGPU() {
        this.CHROME_OPTIONS.addArguments("--disable-gpu");
        return this;
    }

    public ChromeDriverManager setWindowSize(int width, int height) {
        this.CHROME_OPTIONS.addArguments(String.format("--window-size=%d,%d", width, height));
        return this;
    }


}
