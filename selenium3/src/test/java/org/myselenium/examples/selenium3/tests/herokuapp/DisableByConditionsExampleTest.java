package org.myselenium.examples.selenium3.tests.herokuapp;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.myselenium.examples.selenium3.tests.BaseTest;
import org.selenium.examples.selenium3.pages.herokuapp.HerokuAppLandPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Karol Kuta-Orlowicz
 */

/**
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS) annotation allow us to provide non-static method for @BeforeAll methods
 */
@Epic("Smoke tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DisableByConditionsExampleTest extends BaseTest {

    private HerokuAppLandPage herokuAppLandPage;

    @BeforeAll
    public void initPages() {
        herokuAppLandPage = new HerokuAppLandPage(webDriver);
    }

    @BeforeEach
    public void beforeEachTest() {
        webDriver.get("http://the-internet.herokuapp.com/");
    }

    /**
     * An example of disable a test scenario when condition met: system property match with given key.
     * In below case, test will be skipped on CI for Firefox node because, we run test on stage by command:
     * sh 'mvn test -pl selenium3 -DdriverType=REMOTE_FIREFOX'
     */
    @Test
    //@DisabledIfSystemProperty(named = "driverType", matches = "FIREFOX")
    public void shouldDisplayABTestingHref() {
        herokuAppLandPage.clickAbTesting();
        assertTrue(herokuAppLandPage.isAbTestingDisplay());
    }

    @Test
    //@DisabledIfSystemProperty(named = "driverType", matches = "FIREFOX")
    public void shouldDisplayAddRemoveHref() {
        assertTrue(herokuAppLandPage.isAddRemoveElementDisplay());
    }

}
