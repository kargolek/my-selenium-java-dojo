package org.selenium.examples.selenium3.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.net.MalformedURLException;

/**
 * @author Karol Kuta-Orlowicz
 */
public class FirefoxDriverManager implements DriverManagerImpl {

    final FirefoxOptions FIREFOX_OPTIONS = new FirefoxOptions();
    final FirefoxProfile FIREFOX_PROFILE = new FirefoxProfile();

    public WebDriver getDriver() throws MalformedURLException {
        this.FIREFOX_OPTIONS.setProfile(FIREFOX_PROFILE);
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(this.FIREFOX_OPTIONS);
    }

    @Override
    public WebDriver getDriver(MutableCapabilities mutableCapabilities) throws MalformedURLException {
        FirefoxOptions firefoxOptions = (FirefoxOptions) mutableCapabilities;
        firefoxOptions.setProfile(FIREFOX_PROFILE);
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

    /*
    FIXME NEED to find cause that lang is not change from local to EN.
     */
    @Override
    public FirefoxDriverManager setEnglishLanguage() {
        this.FIREFOX_PROFILE.setPreference("intl.accept_languages", "en-GB");
        return this;
    }
}
