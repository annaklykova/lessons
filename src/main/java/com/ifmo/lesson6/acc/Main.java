package com.ifmo.lesson6.acc;

public class Main {
    public static void main(String[] args) {
        Accumulator accPlus = new Accumulator(0, new Plus());
        accPlus.accumulate(33);
        System.out.println(accPlus.getValue());
        accPlus.accumulate(-33);
        System.out.println(accPlus.getValue());
        accPlus.accumulate(88);
        System.out.println(accPlus.getValue());

        Accumulator accMinus = new Accumulator(100, new Minus());
        accMinus.accumulate(50);
        System.out.println(accMinus.getValue());

        Accumulator accMlt = new Accumulator(100, new Multiply());
        accMlt.accumulate(10);
        accMlt.accumulate(2);
        System.out.println(accMlt.getValue());

        Accumulator accDiv = new Accumulator(100, new Operation() {
            @Override
            public double calculate(double a, double b) {
                return a/b;
            }
        });
        accDiv.accumulate(10);
        System.out.println("accDiv.getValue() = " + accDiv.getValue());

    }
}

