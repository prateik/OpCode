package com.concurrency;


class Runner extends Thread{
	
	static int staticCounter;
	
	public void run(){
		
		for(int i=0;i< 10;i++)
		{
			
			
			System.out.println("ID : "+ this.getId()+" NonStatic Counter :"+i+" StaticCounter : "+staticCounter++);
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}



public class BasicThread {

	public static void main(String args[]){
		
		
		System.out.println("Main Thread ID : "+Thread.activeCount());
		Runner r1 = new Runner();
		
		Runner r2 = new Runner();
		Runner r3 = new Runner();
		
		
		r1.start();
		
		System.out.println("Main Thread ID : "+Thread.activeCount());
		r2.start();
		
		System.out.println("Main Thread ID : "+Thread.activeCount());
		r3.start();
		
	}
	
	
}
