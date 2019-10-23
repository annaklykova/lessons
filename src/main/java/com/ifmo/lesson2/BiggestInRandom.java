package com.ifmo.lesson2;

import java.util.Random;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static void main(String[] args) {
        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        // TODO implement
        int a = 100; // Начальное значение диапазона - "от"
        int b = 999; // Конечное значение диапазона - "до"
        int random_number = (int) (Math.random() * ((b - a) + 1)) + a;
        System.out.println(random_number);
        Random r = new Random();
        r.nextInt(999);
        return random_number;
    }

    public static String largestDigit(int n) {
        int h = n / 100;
        int m = (n - h * 100) / 10;
        int l = n % 10;

        int max = 0;
        if (h>m && h>l)max=h;
        else if (m>h && m>l)max=m;
        else max = l;

        return "В числе " + n + " наибольшая цифра " + max + ".";
    }
}
