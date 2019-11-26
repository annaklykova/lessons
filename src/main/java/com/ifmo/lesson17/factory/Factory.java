package com.ifmo.lesson17.factory;

public abstract class Factory {

    abstract Car createCar();

    public static Factory getFactory(CountryCode countryCode) {
        return
                switch (countryCode) {
                    case RUS -> new RusFactory();
                    case JP -> new JapanFactory();
                    case US, USA -> new UsFactory();
                    case GER -> new GerFactory();
                };


    }
}
