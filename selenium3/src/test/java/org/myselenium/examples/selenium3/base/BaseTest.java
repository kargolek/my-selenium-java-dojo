package org.myselenium.examples.selenium3.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.selenium.examples.selenium3.driver.DriverFactory;

import java.net.MalformedURLException;

/**
 * @author Karol Kuta-Orlowicz
 */
public class BaseTest {

    public WebDriver webDriver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        webDriver = new DriverFactory().getDriver();
    }

    @AfterEach
    public void tearDownTest() {
        webDriver.quit();
    }

}
