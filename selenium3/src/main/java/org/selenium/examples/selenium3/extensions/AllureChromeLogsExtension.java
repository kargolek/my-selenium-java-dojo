package org.selenium.examples.selenium3.extensions;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Karol Kuta-Orlowicz
 */
public class AllureChromeLogsExtension extends ExtensionBase implements TestWatcher {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        setLogsOnAllureReport(context);
        TestWatcher.super.testFailed(context, cause);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        setLogsOnAllureReport(context);
        TestWatcher.super.testSuccessful(context);
    }

    private void setLogsOnAllureReport(ExtensionContext context) {
        final WebDriver driver;
        try {
            driver = getWebDriverByReflection(context);
            final Logs logs = driver.manage().logs();
            setAllureAttachmentDriverLogsByType(logs, LogType.BROWSER);
            setAllureAttachmentDriverLogsByType(logs, LogType.SERVER);
            setAllureAttachmentDriverLogsByType(logs, LogType.CLIENT);
            setAllureAttachmentDriverLogsByType(logs, LogType.DRIVER);
        } catch (Exception e) {
            LOGGER.error("Unable to set Allure reports webdriver logs: " + e.getMessage(), e);
        }
    }

    private void setAllureAttachmentDriverLogsByType(Logs logs, String logType) {
        try {
            final String logsPrint = logs.get(logType).getAll().stream().map(Object::toString).collect(Collectors.joining("\n\n"));
            if (!logsPrint.equalsIgnoreCase("")) {
                Allure.addAttachment(logType.toUpperCase(Locale.ROOT), logsPrint);
            } else
                LOGGER.warn("Log attachment will not be created cause is empty " + logType);
        } catch (Exception ignored) {
            LOGGER.warn("Log attachment will not be created cause an error " + logType);
        }
    }
}
