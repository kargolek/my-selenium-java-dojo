package org.myselenium.examples.selenium3.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.selenium.examples.selenium3.driver.DriverFactory;
import org.selenium.examples.selenium3.extensions.AllureChromeLogsExtension;
import org.selenium.examples.selenium3.extensions.OnFailureScreenshotExtension;
import org.selenium.examples.selenium3.extensions.PrintableResultsExtension;
import org.selenium.examples.selenium3.utils.DriverUtil;

import java.net.MalformedURLException;

/**
 * @author Karol Kuta-Orlowicz
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(PrintableResultsExtension.class)
@ExtendWith(OnFailureScreenshotExtension.class)
@ExtendWith(AllureChromeLogsExtension.class)
public abstract class BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public WebDriver webDriver;
    public DriverUtil driverUtil;

    @BeforeAll
    public void setupAll() throws MalformedURLException {
        this.webDriver = new DriverFactory().getDriver();
        LOGGER.info("Init webdriver for:" + getClass().getName());
        driverUtil = new DriverUtil(webDriver);
    }

    @AfterAll
    public void tearDownAll() {
        webDriver.quit();
        LOGGER.info("Tear down webdriver for: " + getClass().getName());
    }

}
