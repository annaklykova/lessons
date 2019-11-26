package com.ifmo.lesson17.factory;

public class Lada implements Car {
    @Override
    public int power() {
        return 180;
    }

    @Override
    public int maxSpeed() {
        return 150;
    }
}
