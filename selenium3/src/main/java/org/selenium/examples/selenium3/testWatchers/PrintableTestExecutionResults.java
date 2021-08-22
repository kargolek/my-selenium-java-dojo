package org.selenium.examples.selenium3.testWatchers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * @author Karol Kuta-Orlowicz
 */
public class PrintableTestExecutionResults implements TestWatcher {

    private static final Logger logger = LoggerFactory.getLogger(PrintableTestExecutionResults.class);

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        logger.error(String.format("TEST PASSED:\nClassName -> %s\nMethodName -> %s\nDisplayName -> %s",
                context.getRequiredTestClass().getSimpleName(), context.getRequiredTestMethod().getName(), context.getDisplayName()));
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        logger.error(String.format("TEST FAILED:\nClassName -> %s\nMethodName -> %s\nDisplayName -> %s\nCause:\n%s",
                context.getRequiredTestClass().getSimpleName(), context.getRequiredTestMethod().getName(),
                context.getDisplayName(), cause));

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
        logger.error(String.format("TEST ABORTED:\nClassName -> %s\nMethodName -> %s\nDisplayName -> %s\nCause:\n%s",
                context.getRequiredTestClass().getSimpleName(), context.getRequiredTestMethod().getName(),
                context.getDisplayName(), cause));

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
        logger.error(String.format("TEST DISABLED:\nClassName -> %s\nMethodName -> %s\nDisplayName -> %s\nReason:\n%s",
                context.getRequiredTestClass().getSimpleName(), context.getRequiredTestMethod().getName(),
                context.getDisplayName(), reason.orElse("NO REASON")));
    }
}
