package com.ifmo.lesson5;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add(new Rectangle(4, 5));
        linkedList.add(new Square(4.5));
        linkedList.add(new Triangle(3, 4, 5));
        linkedList.add(new Rectangle(5,89));
        linkedList.add(new Square(90));
        linkedList.add(new Oval(9,8));
        linkedList.add(new Circle(90));

        double sum = 0;
        for (int i = 0;i<linkedList.lenght;) {
            if (!(linkedList.get(i) == null)) {
                sum += linkedList.get(i).area();
                i++;
            } else break;

        }
        System.out.println(sum);
    }

}

