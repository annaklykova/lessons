package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList<T> implements List<T>, Stack<T>, Queue<T>,Cloneable {
    /** Ссылка на первый элемент списка. */
    private Item<T> head;
    private class Item<T> {
        /** Значение элемента. */
        T value;

        /** Ссылка на следующий элемент. */
        Item<T> next;

        /**
         * Инициализирует элемент со значением
         * {@code value}.
         *
         * @param value Значение, которое будет сохранено
         *              в этом элементе.
         */
        Item(T value) {
            this.value = value;
        }
    }


    /** {@inheritDoc} */
    @Override
    public void add(T val) {
        if (head == null) {
            head = new Item<T>(val);

            return;
        }
        //noinspection ConstantConditions
        find(-1).next = new Item<T>(val);

    }
    private Item<T> find(int i) {
        if (head == null)
            return null;
        if (i == 0)
            return head;

        int cnt = 1;

        for (Item<T> prev = head;;) {
            Item<T> next = prev.next;

            if (next == null)
                return i < 0 ? prev : null;

            if (cnt++ == i)
                return next;

            prev = next;
        }
    }
    /** {@inheritDoc} */
    @Override
    public T take() {
        // TODO implement.

        return remove(0);
    }

    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        Item<T> item = find(i);

        return item == null ? null : item.value;
    }

    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        if (head == null)
            return null;

        if (i == 0) {
            Item<T> h = head;

            head = head.next;

            return h.value;
        }

        Item<T> prev = find(i - 1);
        Item<T> cur;

        if (prev != null && (cur = prev.next) != null) {
            prev.next = cur.next;

            return cur.value;
        }

        return null;

    }

    /** {@inheritDoc} */
    @Override
    public Iterator<T> iterator() {
        // TODO implement.

        return new Iterator<T>() {
            Item<T> item = head;

            @Override
            public boolean hasNext() {
                return item != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T value = item.value;
                    item = item.next;
                    return value;
                }
                return null;
            }
        };
    }

    /** {@inheritDoc} */
    @Override
    public void push(T value) {
        // TODO implement.
        Item item = head;
        head = new Item<T>(value);
        head.next = item;
    }

    /** {@inheritDoc} */
    @Override
    public T pop() {
        // TODO implement.

        return remove(0);
    }
}
