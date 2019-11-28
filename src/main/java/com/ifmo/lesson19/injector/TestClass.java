package com.ifmo.lesson19.injector;

import com.ifmo.lesson17.builder.Pizza;
import com.ifmo.lesson17.factory.Car;
import com.ifmo.lesson17.factory.CountryCode;
import com.ifmo.lesson17.factory.Factory;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    private int a;
    private int b;
    private String s;
    private List l = List.of(2,56,"13");
    @Exclude
    Pizza p;



    public TestClass(int a, int b, String s,Pizza tc) {
        this.a = a;
        this.b = b;
        this.s = s;
        this.p = tc;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}
