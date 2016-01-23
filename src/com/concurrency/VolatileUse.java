package com.concurrency;

import java.util.Scanner;

// volatile keyword
//basic thread sync

class Processor extends Thread{
	
	static int staticCounter;
	private volatile boolean running = true;
	
	public void run(){
		
		for(int i=0;i< 10;i++)
		{
			while(running){
			
			System.out.println("Proccesing ID : "+ this.getId());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
	}
	
	
	public void shutdown(){
		
		running = false;
	}
	
}

public class VolatileUse {
	
	
	public static void main(String args[]){
		
		
		Processor p1 =new Processor();
		p1.start();
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		p1.shutdown();
		
		
	}

}
