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
public class AddRemoveElementPage extends BasePage {

    @FindBy(xpath = "//div[@id='content']//button[text()='Add Element']")
    public WebElement addElementButton;

    public AddRemoveElementPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Is add element button display")
    public boolean isAddElementButtonDisplay() {
        return waitForVisibility(addElementButton, WaitTime.MEDIUM).isDisplayed();
    }
}
