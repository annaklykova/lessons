package com.ifmo.lesson17.builder;

public class Pizza {
    private final String dough;
    private final String cheese;
    private final int ketchup;
    private final int tomatoes;
    private final int pepperoni;

    public static class Builder {
        // Обязательные параметры
        private final String dough;
        private final String cheese;
        // Дополнительные параметры - инициализируются значениями по умолчанию
        private int ketchup = 1;
        private int tomatoes = 1;
        private int pepperoni = 1;
        public Builder(String dough,String cheese) {
            this.dough = dough;
            this.cheese = cheese;
        }
        public Builder ketchup(int val) {
            ketchup = val;
            return this;
        }
        public Builder tomatoes(int val) {
            tomatoes = val;
            return this;
        }
        public Builder pepperoni(int val) {
            pepperoni = val;
            return this;
        }
        public Pizza build() {
            return new Pizza(this);
        }

    }

        private Pizza(Builder builder) {
            dough = builder.dough;
            cheese = builder.cheese;
            ketchup = builder.ketchup;
            tomatoes = builder.tomatoes;
            pepperoni = builder.pepperoni;
        }

    @Override
    public String toString() {
        return "Pizza with "+dough+" dough, "+cheese+" cheese"+ " and ketchup, tomatoes, pepperoni: "+ ketchup + ", "+tomatoes+", "+pepperoni;
    }
}


