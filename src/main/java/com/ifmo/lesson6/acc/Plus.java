package com.ifmo.lesson6.acc;

public class Plus implements Operation{
    @Override
    public double calculate(double a, double b) {
        return a+b;
    }
}
