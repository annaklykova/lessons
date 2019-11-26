package com.ifmo.lesson17.factory;

public class RusFactory extends Factory {
    @Override
    Car createCar() {
        return new Lada();
    }
}
