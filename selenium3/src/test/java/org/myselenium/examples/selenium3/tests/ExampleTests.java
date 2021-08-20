package org.myselenium.examples.selenium3.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.myselenium.examples.selenium3.base.BaseTest;
import org.myselenium.examples.selenium3.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;


public class ExampleTests extends BaseTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        webDriver = new DriverFactory().getDriver(new ChromeOptions());
    }

    @AfterEach
    public void tearDownTest() {
        webDriver.quit();
    }

    @Test
    public void welcomeTest() throws InterruptedException {
        webDriver.get("http://www.google.com");
        Thread.sleep(5000);
    }

    @Test
    public void welcomeTest2() throws InterruptedException {
        webDriver.get("http://www.google.com");
        Thread.sleep(5000);
    }
}
