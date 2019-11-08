package com.ifmo.lesson9;

public class StringAppendable implements Appendable<String> {
    String value;
    String separator;

    public StringAppendable(String value, String separator) {
        this.value = value;
        this.separator = separator;
    }

    @Override
    public StringAppendable append(String t) {
        value = value + separator + t;
        return this;
    }

    @Override
    public String getValue() {
        return value;
    }
}
