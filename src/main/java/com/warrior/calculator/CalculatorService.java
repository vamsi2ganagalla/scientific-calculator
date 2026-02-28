package com.warrior.calculator;

public class CalculatorService {

    public double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(x);
    }

    public long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial of negative number not allowed");
        }

        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural log undefined for zero or negative numbers");
        }
        return Math.log(x);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}