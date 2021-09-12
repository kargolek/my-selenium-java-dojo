package org.myselenium.examples.selenium3.tests;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

/**
 * @author Karol Kuta-Orlowicz
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(PrintableResultsExtension.class)
@ExtendWith(OnFailureScreenshotExtension.class)
@ExtendWith(AllureChromeLogsExtension.class)
public abstract class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public WebDriver webDriver;
    public DriverUtil driverUtil;

    @BeforeAll
    public void setupAll() throws MalformedURLException {
        this.webDriver = new DriverFactory().getDriver();
        logger.info("Init webdriver for:" + getClass().getName());
        driverUtil = new DriverUtil(webDriver);
    }

    @AfterAll
    public void tearDownAll() {
        webDriver.quit();
        logger.info("Tear down webdriver for: " + getClass().getName());
    }

}
