package org.myselenium.examples.selenium3.tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.selenium.examples.selenium3.driver.DriverFactory;
import org.selenium.examples.selenium3.testWatchers.PrintableResultsWatcher;
import org.selenium.examples.selenium3.testWatchers.ScreenshotsFailuresWatcher;
import org.selenium.examples.selenium3.testWatchers.TestClassExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.Optional;

/**
 * @author Karol Kuta-Orlowicz
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(PrintableResultsWatcher.class)
//@ExtendWith(ScreenshotsFailuresWatcher.class)
@ExtendWith(TestClassExtension.class)
public abstract class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public WebDriver webDriver;

    @BeforeAll
    public void setupAll() throws MalformedURLException {
        this.webDriver = new DriverFactory().getDriver();
        logger.info("Init webdriver for:" + getClass().getName());
    }

    @AfterAll
    public void tearDownAll() {
        webDriver.quit();
        logger.info("Tear down webdriver for: " + getClass().getName());
    }

}
