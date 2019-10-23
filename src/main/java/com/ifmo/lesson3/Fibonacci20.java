package com.ifmo.lesson3;

public class Fibonacci20 {
    /*
    Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
    что первый и второй члены последовательности равны единицам, а каждый следующий —
    сумме двух предыдущих.
     */
    public static void main(String[] args) {
        int[] fibonacciNumbers = fibonacciNumbers();
        for (int n:fibonacciNumbers
             ) {
            System.out.println(n);
        }
        // TODO implement
    }

    public static int[] fibonacciNumbers() {
        // TODO implement
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        int a = f[0];
        int b = f[0];
        int n = f.length;
        int i=2;

        while (i < n) {
            f[i] = a + b;
            a = b;
            b = f[i];

            i++;
        }

        return f;
    }

}
