package com.concurrency;

public class Synchronized {
	
	
	
	
	// one option is to use atomic integer
	// second option is to use sync method
	
	//every object in java has an intrinsic lock or monitor or mutex
	// the lock is acquired when calling a synchronized method
	private int count = 0;
	
	
	public  synchronized void increment(){
		
		count++;
		
	}
	public static void main(String args[]){
		
		Synchronized syn = new Synchronized();
		
		syn.doWork();
	}
	
	
	public void doWork(){
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
              for(int i=0;i< 10000;i++){
            	  //count++;
            	  increment();
              }				
			}
		}) ;
		
		
			Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
              for(int i=0;i< 10000;i++){
            	  
            	  increment();
            	  //count++;
            	  //same as count = count + 1;
              }				
			}
		}) ;
		
			
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			System.out.println("Count is :"+count);
	}

}
