package com.concurrency;

public class BasicRunnable {
	
	public static void main(String args[]){
		
		
		 Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Running...");
			}
			
		});
		
		t1.start();
		
		
		
	}

}
