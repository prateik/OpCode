package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// both the threads are working on both lists at the same time and causing issues

// one option is to synchronize both the methods staegOne and stageTwo,but 
// due to this the intrinsic lock of the object is acquired by one thread 
// and the other thread cannot execute the stageTwo method and is blocked.
//so the performance is very poor.


//option two : create separate locks for each method


public class MultipleLocks {
	
	private Random random = new Random();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	public  void printListSizes(){
		
		System.out.println("List 1 : " +list1.size());
		System.out.println("List 2 : " +list2.size());
		
	}
	public void stageOne(){
		
		synchronized(lock1){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list1.add(random.nextInt(100));
		}
	}
	
	public void stageTwo(){
	  
		synchronized(lock2){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list2.add(random.nextInt(100));
		}
	}
	
	
	
	public void process(){
		
	for(int i = 0;i < 1000; i++){
	
    		stageOne();
    		stageTwo();
	}
		
	}
public static void main(String args[]){
	
	   final MultipleLocks ml = new MultipleLocks();
		System.out.println("Starting..");
		
		long start = System.currentTimeMillis();
		
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ml.process();
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ml.process();
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			
			
			
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ml.process();
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken : "+ (end -start));
		ml.printListSizes();
		
	}
	

}
