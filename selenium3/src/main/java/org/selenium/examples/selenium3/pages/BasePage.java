package org.selenium.examples.selenium3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.examples.selenium3.driver.wait.WaitTime;

import java.util.List;

/**
 * @author Karol Kuta-Orlowicz
 */
public class BasePage {

    public final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement waitForVisibilityElement(WebElement webElement, WaitTime waitTime) {
        return new WebDriverWait(webDriver, waitTime.time).until(ExpectedConditions.visibilityOf(webElement));
    }

    public Boolean waitForInvisibilityElement(WebElement webElement, WaitTime waitTime) {
        return new WebDriverWait(webDriver, waitTime.time).until(ExpectedConditions.invisibilityOf(webElement));
    }

    public Boolean waitForInvisibilityElements(List<WebElement> webElements, WaitTime waitTime) {
        return new WebDriverWait(webDriver, waitTime.time).until(ExpectedConditions.invisibilityOfAllElements(webElements));
    }


}
