package com.ifmo.lesson18.reactor;

import java.util.ArrayList;
import java.util.List;

public class Reactor {

    private List<Listener> listeners = new ArrayList<>();

    public void subscribe(Listener listener) {
        listeners.add(listener);
    }
    public void unsubscribe(Listener listener) {
        listeners.remove(listener);
    }

    public void newTemp(Integer temp) {
//        System.out.println("Изменение температуры: " + temp);
        notifyListeners(temp);
    }
    private void notifyListeners(Integer temp) {
        for (Listener listener : listeners)
            listener.publish(temp);
    }
}
