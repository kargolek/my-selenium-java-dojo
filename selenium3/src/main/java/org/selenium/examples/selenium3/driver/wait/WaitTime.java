package org.selenium.examples.selenium3.driver.wait;

/**
 * @author Karol Kuta-Orlowicz
 */
public enum WaitTime {

    RAW(1),
    RARE(5),
    MEDIUM_RARE(10),
    MEDIUM(15),
    MEDIUM_WELL(20),
    WELL_DONE(30);

    public final long time;

    WaitTime(long time) {
        this.time = time;
    }
}
