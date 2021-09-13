package org.selenium.examples.selenium3.pages.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.selenium.examples.selenium3.pages.BasePage;

/**
 * @author Karol Kuta-Orlowicz
 */
public class BasicAuthPage extends BasePage {

    public BasicAuthPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
