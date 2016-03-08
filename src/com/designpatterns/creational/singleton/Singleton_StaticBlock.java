package com.designpatterns.creational.singleton;



public class Singleton_StaticBlock {
    private static final Singleton_StaticBlock instance;

    static {
        try {
            instance = new Singleton_StaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("Darn, an error occurred!", e);
        }
    }

    public static Singleton_StaticBlock getInstance() {
        return instance;
    }

    private Singleton_StaticBlock() {
        // ...
    }
}