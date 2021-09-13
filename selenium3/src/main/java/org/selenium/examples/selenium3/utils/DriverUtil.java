package org.selenium.examples.selenium3.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

/**
 * @author Karol Kuta-Orlowicz
 */
public class DriverUtil {

    private final WebDriver webDriver;
    private Logger logger = LoggerFactory.getLogger(DriverUtil.class);

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
            logger.info(String.format("Unable to get driver logs for a type: %s", logType));
        }
        return String.format("No provided logs type for: %s", logType);
    }
}
