package org.selenium.examples.selenium3.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.examples.selenium3.driver.wait.WaitTime;
import org.selenium.examples.selenium3.pages.BasePage;

import java.util.List;

/**
 * @author Karol Kuta-Orlowicz
 */
public class AddRemoveElementPage extends BasePage {

    @FindBy(xpath = "//div[@id='content']//button[text()='Add Element']")
    public WebElement addElementButton;


    @FindBy(xpath = "//div[@id='elements']//button[@onClick='deleteElement()']")
    public List<WebElement> deleteElementButtons;

    public AddRemoveElementPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Is add element button display")
    public boolean isAddElementButtonDisplay() {
        return waitForVisibilityElement(addElementButton, WaitTime.MEDIUM).isDisplayed();
    }

    @Step("Click on Add remove element")
    public AddRemoveElementPage clickAddElementButton() {
        waitForVisibilityElement(addElementButton, WaitTime.MEDIUM).click();
        return this;
    }

    @Step("Click on Add remove element multiple times: {clickTimes}")
    public AddRemoveElementPage clickAddElementButton(int clickTimes) {
        for (int i = 0; i < clickTimes; i++) {
            clickAddElementButton();
        }
        return this;
    }

    @Step("Click on first Delete element button")
    public AddRemoveElementPage clickFirstDeleteElementButton() {
        waitForVisibilityElement(deleteElementButtons.get(0), WaitTime.MEDIUM).click();
        return this;
    }

    @Step("Click on first Delete element multiple times: {clickTimes}")
    public AddRemoveElementPage clickFirstDeleteElementButton(int clickTimes) {
        for (int i = 0; i < clickTimes; i++) {
            clickFirstDeleteElementButton();
        }
        return this;
    }

    @Step("Click on first Delete element button")
    public AddRemoveElementPage clickLastDeleteElementButton() {
        waitForVisibilityElement(deleteElementButtons.get(deleteElementButtons.size() - 1), WaitTime.MEDIUM).click();
        return this;
    }

    @Step("Click on last Delete element button multiple times: {clickTimes}")
    public AddRemoveElementPage clickLastDeleteElementButton(int clickTimes) {
        for (int i = 0; i < clickTimes; i++) {
            clickLastDeleteElementButton();
        }
        return this;
    }

    @Step("Count Delete element buttons")
    public int countDeleteElements() {
        waitForVisibilityElement(deleteElementButtons.get(0), WaitTime.MEDIUM);
        return deleteElementButtons.size();
    }

    @Step("Is any delete button exist")
    public boolean isDeleteElementRemoved() {
        return waitForInvisibilityElements(deleteElementButtons, WaitTime.MEDIUM);
    }


}
