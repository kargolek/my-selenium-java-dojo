package org.selenium.examples.selenium3.extensions;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

/**
 * @author Karol Kuta-Orlowicz
 */
public class OnFailureScreenshotExtension extends ExtensionBase implements TestWatcher {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        final String testMethodName = context.getRequiredTestMethod().getName();
        LOGGER.info("Take a screenshot for: " + testMethodName);
        try {
            Allure.addAttachment(testMethodName,
                    new ByteArrayInputStream(((TakesScreenshot) getWebDriverByReflection(context)).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception exception) {
            LOGGER.error("An error occur during taking screenshot for failed scenario: "
                    + testMethodName, exception);
        }
        TestWatcher.super.testFailed(context, cause);
    }
}
