package org.myselenium.examples.selenium3.driver.manager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface DriverManagerImpl {
    WebDriver getDriver() throws MalformedURLException;

    WebDriver getDriver(MutableCapabilities options) throws MalformedURLException;

    DriverManagerImpl setIgnoreCertErrors();

    DriverManagerImpl setHeadlessMode();

}
