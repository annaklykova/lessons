package com.ifmo.lesson17.factory;

public class Bmw implements Car {
    @Override
    public int power() {
        return 250;
    }

    @Override
    public int maxSpeed() {
        return 300;
    }
}
