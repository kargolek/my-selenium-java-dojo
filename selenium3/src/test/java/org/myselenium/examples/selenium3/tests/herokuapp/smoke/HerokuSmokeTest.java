package org.myselenium.examples.selenium3.tests.herokuapp.smoke;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myselenium.examples.selenium3.tests.BaseTest;
import org.openqa.selenium.logging.LogType;
import org.selenium.examples.selenium3.pages.herokuapp.HerokuAppLandPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Karol Kuta-Orlowicz
 */
@Epic("Smoke test heroku")
public class HerokuSmokeTest extends BaseTest {

    private HerokuAppLandPage herokuAppLandPage;

    @BeforeAll
    public void setupClass() {
        herokuAppLandPage = new HerokuAppLandPage(this.webDriver);
    }

    @BeforeEach
    public void setupTestMethod() {
        herokuAppLandPage.openLandPage();
    }

    @Test
    @Story("Ab testing href should be display in land page")
    @Feature("Ab testing")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldDisplayAbTesting() {
        assertTrue(herokuAppLandPage.isAbTestingDisplay());
    }

    @Test
    @Story("Open AB Testing page")
    @Feature("Ab testing")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldOpenAbTestingPage() {
        assertThat(herokuAppLandPage.clickAbTestingHref()
                .getTextAbTestControlHeading(), anyOf(startsWith("A/B")));
    }

    @Test
    @Story("Add/Remove Element href should be display in land page")
    @Feature("Add/Remove Element")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldDisplayAddRemoveElement() {
        assertTrue(herokuAppLandPage.isAddRemoveElementDisplay());
    }

    @Test
    @Story("Open Add/Remove element page")
    @Feature("Add/Remove Element")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldOpenAddRemoveElementPage() {
        assertThat(herokuAppLandPage.clickAddRemoveElementHref()
                .isAddElementButtonDisplay(), is(true));
    }

    @Test
    @Story("Basic Auth href should be display in land page")
    @Feature("Basic Auth")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldDisplayBasicAuth() {
        assertTrue(herokuAppLandPage.isBasicAuthHrefAvailable());
    }

    @Test
    @Story("Open Basic Auth page")
    @Feature("Basic Auth")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldOpenBasicAuthPageInStatusUnauthorized() {
        herokuAppLandPage.clickBasicAuthHref();
        assertThat(driverUtil.getLogs(LogType.BROWSER), containsString("status of 401"));
    }

    @Test
    @Story("Broken Image href should be display in land page")
    @Feature("Broken Image")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldDisplayBrokenImage() {
        assertTrue(herokuAppLandPage.isBrokenImagesHrefDisplay());
    }

    @Test
    @Story("Open Broken Image page")
    @Feature("Broken Image")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldOpenBrokenImagePage(){
        assertThat(herokuAppLandPage.clickBrokenImagesHref()
                .getTextBrokenImageHeader(), is("Broken Images"));
    }

    @Test
    @Story("Challenging DOM should be display in land page")
    @Feature("Challenging DOM")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldDisplayChallengingDom() {
        assertTrue(herokuAppLandPage.isChallengingDomHrefDisplay());
    }

    @Test
    @Story("Open Challenging DOM page")
    @Feature("Challenging DOM")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldOpenChallengingDomPage(){
        assertThat(herokuAppLandPage.clickChallengingDomHref()
                .getTextChallengingDomHeader(), is("Challenging DOM"));
    }
}
