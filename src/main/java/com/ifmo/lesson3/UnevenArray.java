package com.ifmo.lesson3;

public class UnevenArray {
    /*
    Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
    этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
    1)
     */
    public static void main(String[] args) {
        int[] unevenArray = unevenArray();
        for (int i:unevenArray) {
            System.out.print(i + " ");
        }
        // TODO implement
        System.out.println();
        for (int i = unevenArray.length-1; i >=0 ; i--) {
            System.out.print(unevenArray[i] + " ");
        }
    }

    public static int[] unevenArray() {
        int[] unevenArray = new int[50];
        int j=0;
        for (int i = 1; i <= 99; i++) {
            if (!(i%2==0)) {
                unevenArray[j]=i;
                j++;
            }

        }
        return unevenArray;

    }
}
