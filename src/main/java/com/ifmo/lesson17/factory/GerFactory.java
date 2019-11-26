package com.ifmo.lesson17.factory;

public class GerFactory extends Factory {
    @Override
    Car createCar() {
        return new Bmw();
    }
}
