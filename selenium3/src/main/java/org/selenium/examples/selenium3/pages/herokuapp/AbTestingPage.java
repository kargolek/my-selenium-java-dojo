package org.selenium.examples.selenium3.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.examples.selenium3.driver.wait.WaitTime;
import org.selenium.examples.selenium3.pages.BasePage;

/**
 * @author Karol Kuta-Orlowicz
 */
public class AbTestingPage extends BasePage {

    @FindBy(xpath = "//div[@id='content']//h3")
    public WebElement abTestControlHeading;

    public AbTestingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Get main header text")
    public String getTextAbTestControlHeading() {
        return waitForVisibilityElement(abTestControlHeading, WaitTime.MEDIUM).getText();
    }
}
