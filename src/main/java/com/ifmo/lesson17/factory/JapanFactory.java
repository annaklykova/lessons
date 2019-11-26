package com.ifmo.lesson17.factory;

public class JapanFactory extends Factory {
    @Override
    Car createCar() {
        return new Toyota();
    }
}
