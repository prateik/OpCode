package com.designpatterns.creational.singleton;

public class Singleton_LazyInit {
	
	private static Singleton_LazyInit instance = null;
	
    public static synchronized Singleton_LazyInit getInstance() {
        if (instance == null) {
            instance = new Singleton_LazyInit();
        }

        return instance;
    }

}
