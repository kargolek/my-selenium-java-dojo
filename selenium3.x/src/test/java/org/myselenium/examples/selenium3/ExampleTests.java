package org.myselenium.examples.selenium3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTests {

    private static String message;

    @BeforeAll
    public static void setup() {
        message = "I'm working";
    }

    @Test
    public void welcomeTest() {
        assertEquals("I'm working", message);
    }

}
