package com.ifmo.lesson3;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        int[] randomNumbers2 = randomNumbers();
        for (int i: randomNumbers1
        ) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: randomNumbers2
        ) {
            System.out.print(i + " ");
        }
        System.out.println();
        // TODO implement

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);

        System.out.println("average1 = " + average1);
        System.out.println("average2 = " + average2);

        if (average1>average2) System.out.println("больше в 1");
        else if (average2>average1) System.out.println("больше во 2");
        else System.out.println("равны");
        // TODO implement
    }

    public static int[] randomNumbers() {
        int[] r = new int[5];
        int a = 0;
        int b = 5;
        for (int i = 0; i < r.length; i++) {
            r[i]= (int) (Math.random() * ((b - a) + 1)) + a;
        }
        return r;
    }

    public static int average(int[] randomNumbers) {
        // TODO implement
        int sum = 0;
        for (int i = 0; i < randomNumbers.length; i++) {
            sum += randomNumbers[i];
        }
        return sum/randomNumbers.length;
    }
}
