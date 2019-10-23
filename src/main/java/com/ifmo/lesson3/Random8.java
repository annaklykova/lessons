package com.ifmo.lesson3;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i]+" ");
        }
        // TODO implement
        System.out.println();
        int[] replacedWithZeros = replaceWithZeros(randomNumbers);
        for (int r:randomNumbers
             ) {
            System.out.print(r+" ");
        }
        // TODO implement
    }

    public static int[] randomNumbers() {
        int[] r = new int[8];
        for (int i = 0; i < r.length; i++) {
            r[i]= (int)(Math.random() * ((9) + 1)) + 1;

        }

        return r;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        // TODO implement
        for (int i = 0; i < randomNumbers.length; i++) {
         if (!(i%2==0))   {
             randomNumbers[i]=0;
            }
        }
        return randomNumbers;
    }
}
