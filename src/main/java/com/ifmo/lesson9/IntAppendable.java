package com.ifmo.lesson9;

public class IntAppendable extends AbstractNumberAppendable<Integer>{

    public IntAppendable(Integer value,ArithmeticOperation<Integer> op) {
        super(value,op);
    }

    @Override
    public IntAppendable append(Integer in) {
        return (IntAppendable) super.append(in);
    }

}
