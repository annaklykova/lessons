package com.ifmo.lesson16.print;

public class Ping implements Command{

private final String text;

    public Ping(String text) {
        this.text = text;
    }
}
