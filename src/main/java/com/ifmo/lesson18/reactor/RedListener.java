package com.ifmo.lesson18.reactor;

public class RedListener implements Listener {
    @Override
    public void publish(Integer message) {
        if (message>=130) System.out.println("RED Temperature "+ message);

    }
}
