package com.ifmo.lesson6.acc;

public class Accumulator {
double value;
Operation op;

    public Accumulator(double value, Operation op) {
        this.value = value;
        this.op = op;
    }

    public void accumulate(double val){
        value = op.calculate(value,val);
    }
    public double getValue(){
        return value;
    }

}
