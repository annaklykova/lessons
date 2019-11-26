package com.ifmo.lesson18.reactor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //green 70, yellow 110, red 130
        Integer[] temp = {69,75,80,75,69,80,100,110,125,115,134,138,124,113,108,90,80,69};
        Reactor reactor = new Reactor();

        reactor.subscribe(new GreenListener());
        reactor.subscribe(new RedListener());
        reactor.subscribe(new YellowListener());


        for (Integer t: temp) {
            reactor.newTemp(t);
            System.out.println("*******");
            Thread.sleep(600);
        }
}
}
