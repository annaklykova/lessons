package com.ifmo.lesson17.factory;

public class UsFactory extends Factory {
    @Override
    Car createCar() {
        return new Crysler();
    }
}
