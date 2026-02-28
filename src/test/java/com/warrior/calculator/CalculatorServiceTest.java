package com.warrior.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    @Test
    void testSqrt() {
        assertEquals(4.0, service.sqrt(16));
    }

    @Test
    void testFactorial() {
        assertEquals(120, service.factorial(5));
    }

    @Test
    void testNaturalLog() {
        assertEquals(Math.log(10), service.naturalLog(10));
    }

    @Test
    void testPower() {
        assertEquals(8.0, service.power(2, 3));
    }
}