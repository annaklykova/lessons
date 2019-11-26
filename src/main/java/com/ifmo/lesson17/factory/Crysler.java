package com.ifmo.lesson17.factory;

public class Crysler implements Car {
    @Override
    public int power() {
        return 220;
    }

    @Override
    public int maxSpeed() {
        return 250;
    }
}
