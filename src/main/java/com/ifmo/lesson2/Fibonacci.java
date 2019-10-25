package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих. 0 1 1 2 3 5 8 13 21 34 55 89 ...
     */
    public static void main(String[] args) {


            int n = 12;
            int a = 1, b = 1;
            System.out.print(a + " " + b);
            int fib = 2, i = 2;
            while (i < n) {
                fib = a + b;
                a = b;
                b = fib;
                System.out.print(" " + fib);
                i++;
            }
        }

    }

