package org.myselenium.examples.selenium3.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.myselenium.examples.selenium3.driver.DriverFactory;
import org.myselenium.examples.selenium3.driver.DriverType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class BaseTest {

    public WebDriver webDriver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        webDriver = DriverFactory.getDriver();
    }

    @AfterEach
    public void tearDownTest(){
        webDriver.quit();
    }

}
