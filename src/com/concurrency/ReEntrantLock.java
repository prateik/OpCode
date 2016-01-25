package com.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
	
	
	ReentrantLock lock = new ReentrantLock();
	

	public void taskOne(){
		
		
		lock.lock();
		
		
		System.out.println(" Locked! Task One in progress..");
		
		
		try {
			//Thread.sleep(1000);
			System.out.println(" Sleepng taskOne count : "+lock.getHoldCount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			
			//lock.unlock();
			System.out.println(" UnLocked! Task One Completed..");
		}
	}
	
	
public void taskTwo(){
		
		
		lock.lock();
		
		
		System.out.println(" Locked! Task Two in progress..");
		
		
		try {
			Thread.sleep(100);
			System.out.println(" Sleepng taskTwo count : "+lock.getHoldCount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			
			lock.unlock();
			lock.unlock();
			System.out.println(" UnLocked! Task Two Completed..");
		}
		}
		
	
	public static void main(String[] args) {
   final ReEntrantLock rlock = new ReEntrantLock();
    
    for(int i=0;i<5;i++)
    {
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
               rlock.taskOne();	
               rlock.taskTwo();
			}
		}).start();
    }
    
	}

}
