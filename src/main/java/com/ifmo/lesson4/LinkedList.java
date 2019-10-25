package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    public Item head;
    public int lenght=0;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
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
    public Object get(int i) {
        // TODO implement
        Item item = head;
        if (head == null) return null;
        else {
            if (i < lenght) {
                for (int j = 0; j < i; j++) {
                    item = item.next;
                }
                return item.value;
            } else return null;
        }

    }

    public Item getItem(int i) {
        // TODO implement
        Item item = head;
        if (head == null) return null;
        else {
            if (i < lenght) {
                for (int j = 0; j < i; j++) {
                    item = item.next;
                }
                return item;
            } else return null;
        }

    }


    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Object remove(int i) {
        Item item = head;
        Item tmp=head;
        if (head == null) return null;
        else if (i==0){
            head = head.next;
            lenght--;
            return tmp.value;
        }
        else if (i < lenght) {
                for (int j = 0; j < i; j++) {
                    tmp = item;
                    item = item.next;
                }
                tmp.next = item.next;
                lenght--;
                return item.value;
            }
        return null;
        }

    }

