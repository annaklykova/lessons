package com.ifmo.lesson12;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utils {


    public static <T,R> Iterable<R> view (Predicate<T> filter, Transformer<T,R> transformer,Iterable<T>... iterables) {
        if (iterables.length==0)
            return List.of();

        Iterable<T> iter = () -> new Iterator<T>() {
            private int pos;
            private Iterator<T> cur;

            @Override
            public boolean hasNext() {
                if(cur==null) cur=iterables[0].iterator();
                if(!cur.hasNext()){
                    pos++;
                    if (pos<iterables.length ){
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

        return null;
    }

    @FunctionalInterface
    interface Predicate<T>{
       boolean isValid(T value);
    }

    public static <T> List<T> filter (List<T> list, Predicate<T> filter){
        List<T> res = new ArrayList<>(list.size());
        for (T item:list) {
            if (filter.isValid(item)) {
                res.add(item);
            }
        }
        return res;
    }

    interface Transformer<T,R>{
        R transform(T value);
    }

    public static <T,R> List<R> transform(List<T> list, Transformer<T,R> transformer){
        List<R> res = new ArrayList<>();
        for (T item: list) {
           R newIt =  transformer.transform(item);
            res.add(newIt);
        }
        res = list.stream().map(transformer::transform).collect(Collectors.toList());
        return res;
    }


    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//        List<String> list3 = new ArrayList<>();
//
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        list1.add(5);
//        list2.add("3");
//        list2.add("4");
//        list3.add("5");
//        list3.add("6");
//        List<Integer> even = filter(list1,i -> i%2 ==0);
//       even.forEach(System.out::println);
//       List<String> tranformed = transform(even, i -> i.toString().concat("transform").concat(i.toString()));
//       tranformed.forEach(System.out::println);
//
//        System.out.println("===");
//        filter(list1, i -> i>2).forEach(System.out::println);

//        Iterable<String> view = view(list1,list2,list3);

//        list1.add(77);

//        for (String s: view) {
//            System.out.println(s);
//        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        var evenList = filter(list,i -> i%2==0);
        System.out.println(evenList);

        var trancformedList = transform(list,i -> String.valueOf(i.doubleValue()-i*4));
        System.out.println(trancformedList);

        var strList = filter(trancformedList, i-> i.length()>4);
        System.out.println(strList);

        var powList = transform(list,i -> Math.pow(2,i));
        System.out.println(powList);
    }
}


