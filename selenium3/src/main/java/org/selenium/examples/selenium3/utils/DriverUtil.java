package org.selenium.examples.selenium3.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.stream.Collectors;

/**
 * @author Karol Kuta-Orlowicz
 */
public class DriverUtil {

    private final WebDriver webDriver;
    private static final Logger LOGGER = LogManager.getLogger();

    public DriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getLogs(String logType) {
        try {
            return webDriver.manage().logs().get(logType).getAll()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n\n"));
        } catch (Exception e) {
            LOGGER.error(String.format("Unable to get driver logs for a type: %s", logType));
        }
        return String.format("No provided logs type for: %s", logType);
    }
}
