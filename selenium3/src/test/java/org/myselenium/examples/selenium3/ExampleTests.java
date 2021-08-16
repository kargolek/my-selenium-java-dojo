package org.myselenium.examples.selenium3;

import org.junit.jupiter.api.Test;
import org.myselenium.examples.selenium3.base.BaseTest;

public class ExampleTests extends BaseTest {

    @Test
    public void welcomeTest() throws InterruptedException {
        webDriver.get("http://www.google.com");
        Thread.sleep(20000);
    }
}
