package com.ifmo.lesson9;

public abstract class AbstractNumberAppendable<T extends Number> implements Appendable<T> {
    ArithmeticOperation<T> op;
    T value;

    public AbstractNumberAppendable(T value,ArithmeticOperation<T> op) {
        this.op = op;
        this.value = value;
    }

    public AbstractNumberAppendable<T> append(T o) {
        value = op.calculate(value,o);
        return this;
    }

    public T getValue() {
        return value;
    }

}
