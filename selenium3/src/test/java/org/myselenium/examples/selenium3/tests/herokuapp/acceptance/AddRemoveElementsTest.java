package org.myselenium.examples.selenium3.tests.herokuapp.acceptance;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myselenium.examples.selenium3.tests.BaseTest;
import org.selenium.examples.selenium3.pages.herokuapp.HerokuAppLandPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Karol Kuta-Orlowicz
 */
@Epic("Add/Remove elements tests")
public class AddRemoveElementsTest extends BaseTest {

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
    @Story("Verify add one element")
    @Feature("Add/Remove Element")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldAddOneElement() {
        assertThat(herokuAppLandPage.clickAddRemoveElementHref()
                .clickAddElementButton()
                .countDeleteElements(), is(1));

    }

    @Test
    @Story("Verify add twenty element")
    @Feature("Add/Remove Element")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldAdd20Element() {
        assertThat(herokuAppLandPage.clickAddRemoveElementHref()
                .clickAddElementButton(20)
                .countDeleteElements(), is(20));

    }

    @Test
    @Story("Delete one element after click on it")
    @Feature("Add/Remove Element")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldRemoveOneElement() {
        assertThat(herokuAppLandPage.clickAddRemoveElementHref()
                .clickAddElementButton()
                .clickFirstDeleteElementButton()
                .isDeleteElementRemoved(), is(true));
    }

    @Test
    @Story("Delete 5 elements after click on it")
    @Feature("Add/Remove Element")
    @Severity(SeverityLevel.NORMAL)
    public void shouldRemoveMultipleElements() {
        assertThat(herokuAppLandPage.clickAddRemoveElementHref()
                .clickAddElementButton(10)
                .clickFirstDeleteElementButton(5)
                .countDeleteElements(), is(5));
    }

    @Test
    @Story("Delete boundary elements after click on it")
    @Feature("Add/Remove Element")
    @Severity(SeverityLevel.NORMAL)
    public void shouldDeleteBoundaryElements() {
        assertThat(herokuAppLandPage.clickAddRemoveElementHref()
                .clickAddElementButton(10)
                .clickFirstDeleteElementButton(4)
                .clickLastDeleteElementButton(4)
                .countDeleteElements(), is(2));
    }
}
