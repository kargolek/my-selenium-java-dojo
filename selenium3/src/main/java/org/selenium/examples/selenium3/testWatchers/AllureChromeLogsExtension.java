package org.selenium.examples.selenium3.testWatchers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Karol Kuta-Orlowicz
 */
public class AllureChromeLogsExtension extends TestWatcherBase implements TestWatcher {

    private static final Logger logger = LoggerFactory.getLogger(AllureChromeLogsExtension.class);

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
            logger.error("Unable to set Allure reports webdriver logs: " + e.getMessage(), e);
        }
    }

    private void setAllureAttachmentDriverLogsByType(Logs logs, String logType) {
        try{
            final String logsPrint = logs.get(logType).getAll().stream().map(Object::toString).collect(Collectors.joining("\n\n"));
            if (!logsPrint.equalsIgnoreCase("")) {
                Allure.addAttachment(logType.toUpperCase(Locale.ROOT), logsPrint);
            } else
                logger.info("Log attachment will not be created cause is empty " + logType);
        } catch (Exception ignored){
            logger.info("Log attachment will not be created cause an error " + logType);
        }
    }
}
