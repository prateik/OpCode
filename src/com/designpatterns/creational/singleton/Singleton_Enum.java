package com.designpatterns.creational.singleton;

public class Singleton_Enum {
	public enum Singleton {
	    INSTANCE;
	    public void execute (String arg) {
	        System.out.println(" Singleton executed!");
	    }
	}
	
	
	public static void main(String args[]){
		
		Singleton.INSTANCE.execute(null);
		
	}
}
