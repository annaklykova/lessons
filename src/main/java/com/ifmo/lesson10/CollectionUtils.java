package com.ifmo.lesson10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionUtils {



    public static <T> Iterable<T> view (Iterable<T>... iterables) {

        if (iterables.length==0)
            return List.of();

        Iterable<T> iter = new Iterable<T>() {

            @Override
            public Iterator<T> iterator() {

                return new Iterator<T>() {
                    private int pos;
                    private Iterator<T> cur;

                    @Override
                    public boolean hasNext() {
                        if(cur==null) cur=iterables[0].iterator();
                        if(!cur.hasNext()){
                            pos++;
                            if (pos<iterables.length){
                                cur=iterables[pos].iterator();
                            } else return false;
                        }

                        return cur.hasNext();
                    }

                    @Override
                    public T next() {


                        return cur.next();
                    }
                };
            }

        };
        return iter;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list1.add("1");
        list1.add("2");
        list2.add("3");
        list2.add("4");
        list3.add("5");
        list3.add("6");

        Iterable<String> view = view(list1,list2,list3);

        for (String s: view) {
            System.out.println(s);
        }

    }
}

