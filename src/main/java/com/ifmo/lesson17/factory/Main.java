package com.ifmo.lesson17.factory;

import com.ifmo.lesson17.builder.Pizza;

public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory(CountryCode.RUS);
        Car lada = factory.createCar();
        System.out.println(lada instanceof Lada);

        Pizza pizza = new Pizza.Builder("thin","parmezan").ketchup(8).pepperoni(2).build();
        System.out.println(pizza);
    }
}

