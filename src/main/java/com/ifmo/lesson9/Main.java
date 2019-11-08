package com.ifmo.lesson9;

public class Main {
    public static void main(String[] args) {

    ArithmeticOperation opMinus = new ArithmeticOperation<Double>() {
    @Override
    public Double calculate(Double a, Double b) {
        return a-b;
    }
};
        DoubleAppendable da = new DoubleAppendable(88.9, opMinus);
        System.out.println(da.value);
        da.append(55.9).append(998.8);
        System.out.println(da.value);

        IntAppendable intAp = new IntAppendable(10,new ArithmeticOperation<Integer>() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println("intAp = " + intAp.append(88).append(100).getValue());


        StringAppendable sa = new StringAppendable("strinq1","//");
        System.out.println("sa.value = " + sa.append("sdfs").getValue());
        sa.append("string2").append("string4").append("rebegv");
        System.out.println(sa.value);
    }
}
