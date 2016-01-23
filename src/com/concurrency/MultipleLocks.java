package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocks {
	
	private Random random = new Random();
	
	private List<Integer> list1 =new ArrayList<Integer>();
	private List<Integer> list2 =new ArrayList<Integer>();
	
	
	public void stageOne(){
		
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list1.add(random.nextInt(100));
	}
	
	public void stageTwo(){
	  try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list2.add(random.nextInt(100));
	}
	
	
	
	public void process(){
		
	for(int i =0;i < 1000; i++){}
	
    		stageOne();
    		stageTwo();
		
	}
public static void main(String args[]){
	
	   MultipleLocks ml = new MultipleLocks();
		System.out.println("Starting..");
		
		long start = System.currentTimeMillis();
		
		ml.process();
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken : "+ (end -start));
		
	}
	

}
