package com.ifmo.lesson5;

public class Oval extends Shape {
    double r1;
    double r2;
    double p = 3.14;

    public Oval(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public double area() {
        return p*r1*r2;
    }
}
