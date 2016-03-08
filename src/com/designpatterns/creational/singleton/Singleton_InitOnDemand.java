package com.designpatterns.creational.singleton;


public class Singleton_InitOnDemand {
    // Private constructor. Prevents instantiation from other classes.
    private Singleton_InitOnDemand() { }

    /**
     * Initializes singleton.
     *
     * {@link SingletonHolder} is loaded on the first execution of {@link Singleton#getInstance()} or the first access to
     * {@link SingletonHolder#INSTANCE}, not before.
     */
    private static class SingletonHolder {
            private static final Singleton_InitOnDemand INSTANCE = new Singleton_InitOnDemand();
    }

    public static Singleton_InitOnDemand getInstance() {
            return SingletonHolder.INSTANCE;
    }
}