package com.ifmo.lesson6;

public class Main2 {
    public static void main(String[] args) {
//        var arrList = new ArrayList<String>();
//        arrList.add("0ewref");
//        arrList.add("1svcdszv");
//        arrList.add("2svcdszv");
//        arrList.add("3svcdszv");
//        arrList.add("4svcdszv");
//        arrList.add("5svcdszv");
//        arrList.add("6svcdszv");
//        System.out.println("arrList[0] = " + arrList.get(0));
//        for (String s : arrList
//        ) {
//            System.out.println("s = " + s);
//        }
//        System.out.println(" = ");
//
//        arrList.remove(5);
//        arrList.add("7svcdszv");
//
//        for (String s : arrList
//        ) {
//            System.out.println("s = " + s);
//        }
//
//
//        var doubleList = new ArrayList<Double>();
//        doubleList.add(9.7);

        Stack<String> stack = new LinkedList<String>();

      stack.push("1");
      stack.push("2");
      stack.push("3");

        System.out.println(stack.pop()); // "3"
        System.out.println(stack.pop()); // "2"
        System.out.println(stack.pop()); // "1"
        System.out.println(stack.pop()); // null

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");


        System.out.println( queue.take()); // "1"
        System.out.println(queue.take()); // "2"
        System.out.println(queue.take()); // "3"
        System.out.println(queue.take()); // null

    }

}
