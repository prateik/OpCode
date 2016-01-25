package com.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor2 implements Runnable{
	
	private CountDownLatch latch;
	
	private int id;
	
	
	public Processor2(CountDownLatch latch){
		this.latch=latch;
	}
	
	public void run(){
		
		
		System.out.println("Starting..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		latch.countDown();
		
		System.out.println("Completed.."+id);
		}
	
	   
		
	}




public class CountdownLatches {
	
	public static void main(String args[]){
		
		CountDownLatch latch = new CountDownLatch(5);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0;i< 3;i++){
			executor.submit(new Processor2(latch));
			
		}
		
		try {
			latch.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
