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
public class BrokenImagePage extends BasePage {

    @FindBy(xpath = "//div[@class='example']//h3")
    private WebElement brokenImageHeader;

    public BrokenImagePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Get header text")
    public String getTextBrokenImageHeader() {
        return waitForVisibilityElement(brokenImageHeader, WaitTime.MEDIUM).getText();
    }
}
