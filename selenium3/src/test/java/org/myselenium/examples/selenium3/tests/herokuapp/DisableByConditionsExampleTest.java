package org.myselenium.examples.selenium3.tests.herokuapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.myselenium.examples.selenium3.tests.BaseTest;
import org.selenium.examples.selenium3.pages.herokuapp.HerokuAppLandPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Karol Kuta-Orlowicz
 */

@DisplayName("An example for disable test by condition")
/**
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS) annotation allow us to provide non-static method for @BeforeAll methods
 */
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
    @DisplayName("Verify AB Testing is display")
    @DisabledIfSystemProperty(named = "driverType", matches = "REMOTE_FIREFOX")
    public void shouldDisplayABTestingHref() {
        assertTrue(herokuAppLandPage.isAbTestingDisplay());
    }

    @Test
    @DisplayName("Verify Add/Remove Elements is display")
    @DisabledIfSystemProperty(named = "driverType", matches = "REMOTE_FIREFOX")
    public void shouldDisplayAddRemoveHref() {
        assertFalse(herokuAppLandPage.isAddRemoveElementDisplay());
    }

}
