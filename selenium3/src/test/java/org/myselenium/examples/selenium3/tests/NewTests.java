package org.myselenium.examples.selenium3.tests;

import org.junit.jupiter.api.Test;
import org.myselenium.examples.selenium3.base.BaseTest;
/**
 * @author Karol Kuta-Orlowicz
 */
public class NewTests extends BaseTest {

    @Test
    public void welcomeTest() throws InterruptedException {
        webDriver.get("http://www.google.com");
        Thread.sleep(5000);
    }

    @Test
    public void welcomeTest2() throws InterruptedException {
        webDriver.get("http://www.google.com");
        Thread.sleep(5000);
    }

    @Test
    public void welcomeTest3() throws InterruptedException {
        webDriver.get("http://www.google.com");
        Thread.sleep(5000);
    }
}
