package com.ifmo.lesson5;

public class Rectangle extends Shape {
    double a;
    double b;

    public Rectangle(double a, double b ) {
        this.a = a;
        this.b = b;
    }

    public double area(){
        return a*b;
    }

}
