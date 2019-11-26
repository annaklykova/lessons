package com.ifmo.lesson18.reactor;

public class GreenListener implements Listener {
    @Override
    public void publish(Integer message) {
    if (message>=70) System.out.println("GREEN Temperature "+ message);
    }
}
