package org.selenium.examples.selenium3.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Karol Kuta-Orlowicz
 */
public abstract class ExtensionBase {

    private static final Logger LOGGER = LogManager.getLogger();

    final WebDriver getWebDriverByReflection(ExtensionContext context) throws Exception {
        final Field webDriverField = Arrays.stream(context.getRequiredTestInstance().getClass().getFields())
                .filter(e -> e.getType().isAssignableFrom(WebDriver.class))
                .collect(Collectors.toList())
                .stream().findFirst().orElseThrow(() -> new Exception("Unable to get webdriver field"));
        webDriverField.setAccessible(true);
        try {
            return (WebDriver) webDriverField.get(context.getRequiredTestInstance());
        } catch (IllegalAccessException e) {
            LOGGER.error("Unable to get webdriver by reflection");
        }
        throw new NullPointerException("Unable to get instance of a webdriver object");
    }

}
