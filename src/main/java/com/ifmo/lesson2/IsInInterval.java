package com.ifmo.lesson2;

public class IsInInterval {
    /*
     Создать программу, которая будет проверять попало ли случайно выбранное из отрезка
    [5;155] целое число в интервал (25;100) и сообщать результат на экран.Примеры работы
    программы:
    Число 113 не содержится в интервале (25,100) Число 72 содержится в интервале (25,100) 
    Число 25 не содержится в интервале (25,100) Число 155 не содержится в интервале (25,100) 
     */
    public static void main(String[] args) {
        int rnd = randomInt();

        String inInterval = isInInterval(rnd);
        System.out.println(inInterval);
        // TODO implement
    }

    public static int randomInt() {
        // TODO implement
        int a = 5; // Начальное значение диапазона - "от"
        int b = 155; // Конечное значение диапазона - "до"
        int random_number = (int) (Math.random() * ((b - a) + 1)) + a;

        return random_number;
    }

    public static String isInInterval(int rnd) {
        // TODO implement
        if (rnd>25 && rnd<100) return "Число "+rnd+" содержится в интервале (25,100)";
        else  return "Число "+rnd+" не содержится в интервале (25,100)";
    }

}
