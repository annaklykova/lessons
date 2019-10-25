package com.ifmo.lesson5;

import com.ifmo.lesson5.Item;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;
    public int lenght = 0;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Shape val) {
        // TODO implement
       if (head==null){
           head = new Item(val);
           lenght++;
       } else  {
           Item item = head;

           while (true) {
               if (item.next == null){
                   item.next = new Item(val);
                   lenght++;
                   return;
               }
               item = item.next;
           }
       }


    }

    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Shape get(int i) {
        // TODO implement
        Item item = head;
        if (head == null) return null;
        else {

            for (int j = 0; j < i; j++) {
            item = item.next;
            }
            return item.value;
        }
    }




    }

