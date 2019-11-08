package com.ifmo.lesson9;

public class DoubleAppendable extends AbstractNumberAppendable<Double> {
    private static final ArithmeticOperation<Double> DEFAULT = new ArithmeticOperation<Double>() {
        @Override
        public Double calculate(Double a, Double b) {
            return null;
        }
    };

    public DoubleAppendable(Double value, ArithmeticOperation<Double> op) {
        super(value, op);
    }

    public DoubleAppendable() {
        super(0.0, DEFAULT);
    }

    public DoubleAppendable append(Double o) {
        return (DoubleAppendable) super.append(o);
    }


}
