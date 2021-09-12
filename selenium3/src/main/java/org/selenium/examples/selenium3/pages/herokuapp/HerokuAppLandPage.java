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
public class HerokuAppLandPage extends BasePage {

    @FindBy(xpath = "//div[@id='content']//a[@href='/abtest']")
    private WebElement abTestingHref;

    @FindBy(xpath = "//div[@id='content']//a[@href='/add_remove_elements/']")
    private WebElement addRemoveElementHref;

    @FindBy(xpath = "//div[@id='content']//a[@href='/basic_auth']")
    private WebElement basicAuthHref;

    @FindBy(xpath = "//div[@id='content']//a[@href='/broken_images']")
    private WebElement brokenImagesHref;

    @FindBy(xpath = "//div[@id='content']//a[@href='/challenging_dom']")
    private WebElement challengingDomHref;

    public HerokuAppLandPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Open HerokuApp land page")
    public HerokuAppLandPage openLandPage() {
        this.webDriver.get("http://the-internet.herokuapp.com/");
        return this;
    }

    @Step("Is Ab testing displayed")
    public boolean isAbTestingDisplay() {
        return waitForVisibility(abTestingHref, WaitTime.MEDIUM).isDisplayed();
    }

    @Step("Click on Ab Testing href")
    public AbTestingPage clickAbTestingHref() {
        waitForVisibility(abTestingHref, WaitTime.MEDIUM).click();
        return new AbTestingPage(this.webDriver);
    }

    @Step("Is Add/Remove element displayed")
    public boolean isAddRemoveElementDisplay() {
        return waitForVisibility(addRemoveElementHref, WaitTime.MEDIUM).isDisplayed();
    }

    @Step("Click on Add/Remove element href")
    public AddRemoveElementPage clickAddRemoveElementHref() {
        waitForVisibility(addRemoveElementHref, WaitTime.MEDIUM).click();
        return new AddRemoveElementPage(webDriver);
    }

    @Step("Is Basic Auth displayed")
    public boolean isBasicAuthHrefAvailable() {
        return waitForVisibility(basicAuthHref, WaitTime.MEDIUM).isDisplayed();
    }

    @Step("Click on Basic Auth href")
    public BasicAuthPage clickBasicAuthHref() {
        waitForVisibility(basicAuthHref, WaitTime.MEDIUM).click();
        return new BasicAuthPage(webDriver);
    }

    @Step("Is Broken image displayed")
    public boolean isBrokenImagesHrefDisplay() {
        return waitForVisibility(brokenImagesHref, WaitTime.MEDIUM).isDisplayed();
    }

    @Step("Click on Broken image href")
    public BrokenImagePage clickBrokenImagesHref() {
        waitForVisibility(brokenImagesHref, WaitTime.MEDIUM).click();
        return new BrokenImagePage(webDriver);
    }

    @Step("Is Challenging DOM displayed")
    public boolean isChallengingDomHrefDisplay() {
        return waitForVisibility(challengingDomHref, WaitTime.MEDIUM).isDisplayed();
    }

    @Step("Click on Challenging DOM href")
    public ChallengingDomPage clickChallengingDomHref() {
        waitForVisibility(challengingDomHref, WaitTime.MEDIUM).click();
        return new ChallengingDomPage(webDriver);
    }


}
