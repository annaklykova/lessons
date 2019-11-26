package com.ifmo.lesson17.factory;

public class Toyota implements Car {
    @Override
    public int power() {
        return 250;
    }

    @Override
    public int maxSpeed() {
        return 280;
    }
}
