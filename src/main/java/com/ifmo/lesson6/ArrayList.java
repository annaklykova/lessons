package com.ifmo.lesson6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Этот класс должен реализовывать следующие методы: add(), get(), remove() и iterator() из интерфейса List.
 * Если при выполнении add() в массиве нет свободных элементов, то создать новый - вдвое больше,
 * скопировать в него все значения из старого и + 1, который сейчас добавляется.
 * Удаление должно сдвинуть все элементы влево, если это требуется.
 * Например, если список с такими элементами:
 * |0|1|2|3|4|5|
 * Удаляем элемент по индексу 2:
 * |0|1|_|3|4|5|
 * Перемещаем все элементы влево:
 * |0|1|3|4|5|_|
 * Теперь при итерации по ним после 1 будет идти сразу 3, как в связном списке.
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 10;

    private Object[] values;

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    private int lastInd;
    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {
        values = new Object[initialSize];
    }

    /** {@inheritDoc} */
    @Override
    public void add(T val) {
        // TODO implement.

        for (int i = 0; i < values.length;) {
            if (values[i]==null) {
                values[i]=val;
                break;
            } else {
                if ((i == values.length - 1)) {
                    values = Arrays.copyOf(values, values.length * 2);
                    values[i+1] = val;
                    break;
                }
                i++;
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        // TODO implement.
        if (i>=0 && i<values.length)
        return (T) values[i];
     return null;
}


    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        // TODO implement.
        if (i>=0 && i< values.length) {
            T v = (T) values[i];
            for (int j = i; j < values.length - 1; j++) {
                values[j] = values[j + 1];
                values[j + 1] = null;
            }
            return v;
        } else return null;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index<values.length;
            }

            @Override
            public T next() {
                return get(index++);
            }

        };
    }

//    private class ArrayListIterator implements Iterator<T> {
//
//        private int index;
//
//        @Override
//        public boolean hasNext() {
//
//            return index < values.length;
//        }
//
//        @Override
//        public T next() {
//            return get(index++);
//        }
//    }
}
