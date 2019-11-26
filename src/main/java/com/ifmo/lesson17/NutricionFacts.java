package com.ifmo.lesson17;

public class NutricionFacts {
    private final int servings;
    private final int calories;
    private final int fat;

    public static class Builder {
        // Обязательные параметры
        private final int servings;
        // Дополнительные параметры - инициализируются значениями по умолчанию
        private int calories = 0;
        private int fat = 0;
        public Builder(int servings) {
            this.servings = servings;
        }
        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public NutricionFacts build() {
            return new NutricionFacts(this);
        }
    }
    private NutricionFacts(Builder builder) {
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }
}