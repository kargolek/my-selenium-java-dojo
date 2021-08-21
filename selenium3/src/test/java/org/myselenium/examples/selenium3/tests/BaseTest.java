package org.myselenium.examples.selenium3.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.selenium.examples.selenium3.driver.DriverFactory;

import java.net.MalformedURLException;

/**
 * @author Karol Kuta-Orlowicz
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public WebDriver webDriver;

    @BeforeAll
    public void setup() throws MalformedURLException {
        this.webDriver = new DriverFactory().getDriver();
    }

    @AfterAll
    public void tearDownTest() {
        webDriver.quit();
    }

}
