package org.selenium.examples.selenium3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.examples.selenium3.driver.wait.WaitTime;

/**
 * @author Karol Kuta-Orlowicz
 */
public class BasePage {

    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement waitForVisibility(WebElement webElement, WaitTime waitTime) {
        return new WebDriverWait(webDriver, waitTime.time).until(ExpectedConditions.visibilityOf(webElement));
    }

}
