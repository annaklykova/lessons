package com.ifmo.lesson3;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        for (int i: randomNumbers
             ) {
            System.out.print(i + " ");
        }
        // TODO implement

        int max = max(randomNumbers);
        System.out.println();
        System.out.println(max);
        int maxLastIndex = lastIndexOf(randomNumbers, max);
        System.out.println(maxLastIndex);

        // TODO implement
    }

    public static int[] randomNumbers() {
        int[] r = new int[12];
        int a = -15;
        int b = 15;
        for (int i = 0; i < r.length; i++) {
            r[i]= (int) (Math.random() * ((b - a) + 1)) + a;
        }
        return r;
    }

    public static int max(int[] randomNumbers) {
        // TODO implement
        int max = -15;
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i]>=max) max = randomNumbers[i];
        }

        return max;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        for (int i = randomNumbers.length-1; i >= 0 ; i--) {
            if (randomNumbers[i] == max) return i;
        } return -1;
    }
}
