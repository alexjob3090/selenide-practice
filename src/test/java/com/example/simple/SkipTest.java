package com.example.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkipTest {
    @Test
    @Disabled
    public void test2() {
        assertTrue(false);
    }
}
