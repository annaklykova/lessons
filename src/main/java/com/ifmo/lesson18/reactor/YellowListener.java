package com.ifmo.lesson18.reactor;

public class YellowListener implements Listener {
    @Override
    public void publish(Integer message) {
        if (message>=110) System.out.println("YELLOW Temperature "+ message);

    }
}
