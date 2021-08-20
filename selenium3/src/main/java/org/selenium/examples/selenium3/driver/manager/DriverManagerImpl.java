package org.selenium.examples.selenium3.driver.manager;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
/**
 * @author Karol Kuta-Orlowicz
 */
public interface DriverManagerImpl {
    WebDriver getDriver() throws MalformedURLException;

    WebDriver getDriver(MutableCapabilities options) throws MalformedURLException;

    DriverManagerImpl setIgnoreCertErrors();

    DriverManagerImpl setHeadlessMode();

}
