package com.designpatterns.creational.singleton;

public class Singleton_EagerInit {

	
	private static Singleton_EagerInit singletonObj = new Singleton_EagerInit();
	
	private Singleton_EagerInit(){
	
	}
   
	 public static Singleton_EagerInit getSingleton(){
		 return singletonObj;
	 }
	
	public static void main(String[] args) {

	}

}
