package org.selenium.examples.selenium3.testWatchers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * @author Karol Kuta-Orlowicz
 */
public class OnFailureScreenshotExtension extends ExtensionBase implements TestWatcher {

    private final static Logger logger = LoggerFactory.getLogger(OnFailureScreenshotExtension.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        final String testMethodName = context.getRequiredTestMethod().getName();
        logger.info("Take a screenshot for: " + testMethodName);
        try {
            Allure.addAttachment(testMethodName,
                    new ByteArrayInputStream(((TakesScreenshot) getWebDriverByReflection(context)).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception exception) {
            logger.error("An error occur during taking screenshot for failed scenario: "
                    + testMethodName, exception);
        }
        TestWatcher.super.testFailed(context, cause);
    }
}
