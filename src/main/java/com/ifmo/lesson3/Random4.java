package com.ifmo.lesson3;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        for (int r: randomNumbers
             ) {
            System.out.println(r);
        }

        System.out.println(isIncreasingSequence(randomNumbers));
        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] r = new int[4];
        for (int i = 0; i < r.length; i++) {
            r[i]= (int)(Math.random() * ((89) + 1)) + 10;

        }

        return r;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        // TODO implement
        boolean isIncr=false;
        for (int i = 0; i < randomNumbers.length-1; i++) {
            if (randomNumbers[i]<randomNumbers[i+1]) isIncr=true;
            else return isIncr =false;

        }
        return isIncr;
    }
}
