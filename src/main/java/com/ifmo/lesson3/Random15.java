package com.ifmo.lesson3;

public class Random15 {
    /*
     Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
     Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
     отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        for (int i: randomNumbers
             ) {
            System.out.println(i);
        }
        // TODO implement

        int evens = evens(randomNumbers);
        System.out.println(evens);
        // TODO implement
    }

    public static int[] randomNumbers() {
        int[] r = new int[15];
        int a = 0;
        int b = 9;
        for (int i = 0; i < r.length; i++) {
            r[i]= (int) (Math.random() * ((b - a) + 1)) + a;
        }
        return r;
    }

    private static int evens(int[] arr) {
        // TODO implement
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0) count++;
        }
        return count;
    }
}
