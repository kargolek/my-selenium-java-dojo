package org.selenium.examples.selenium3.pages.herokuapp;

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

    public boolean isAbTestingDisplay() {
        return waitForVisibility(abTestingHref, WaitTime.MEDIUM).isDisplayed();
    }
}
