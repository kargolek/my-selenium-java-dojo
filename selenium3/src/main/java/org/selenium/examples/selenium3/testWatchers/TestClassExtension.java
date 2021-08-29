package org.selenium.examples.selenium3.testWatchers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.*;

import java.util.Optional;

/**
 * @author Karol Kuta-Orlowicz
 */
public class TestClassExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        Allure.story(Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        Allure.label("Browser" , Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        System.out.println("RUN ALLURE");
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        Allure.label("Browser" , Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        Allure.story(Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        System.out.println("RUN ALLURE");
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
        Allure.label("Browser" , Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        Allure.story(Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        System.out.println("RUN ALLURE");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        Allure.label("Browser" , Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        Allure.story(Optional.ofNullable(System.getProperty("driverType")).orElse("CHROME"));
        System.out.println("RUN ALLURE");
    }
}
