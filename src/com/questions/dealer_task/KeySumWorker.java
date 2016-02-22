package com.questions.dealer;

import java.util.Hashtable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class KeySumWorker implements Runnable {
	private  BlockingQueue<String> queue;
	private static Hashtable<String, Integer> result;
	static Pattern p = Pattern.compile("[a-zA-Z]+[\\s,;]+[\\,[0-9]]+");
	private volatile boolean isRunning = true;
	
	KeySumWorker(BlockingQueue<String> q, Hashtable<String, Integer> map) {
		this.queue = q;
		this.result = map;
	}

	public  boolean isValidEntry(String entry) {
		return  p.matcher(entry).matches();

	}


	

	@Override
	public void run() {
		
		String value = null;
		
		while(isRunning){
		try {

			value = queue.poll(2,TimeUnit.MILLISECONDS);
			
			if(value == null) {
				isRunning = false;
			
			}
			
			else if(value == "QUEUE_END"){
			
				queue.add(value);
                isRunning = false;
	            System.out.println(" POISON PILL DETECTED!");
	            
	            KeySumDriver.shutdownExecutor();
	            
			}
			else{
			
			if(isValidEntry(value)){
				
			    String[] kelval = value.split(",");
			
			     if(result.get((String)kelval[0])== null || !result.containsKey(kelval[0])){
			        result.put(kelval[0], Integer.valueOf(kelval[1]));
			System.out.println("ADDING NEW : "+kelval[0]+","+kelval[1]);
			        }
			     else{
				
				    Integer tempVal = result.get(kelval[0]);
				    System.out.println("ADDING :  "+kelval[0]+","+(tempVal+Integer.valueOf(kelval[1])));
				    result.put(kelval[0], tempVal+Integer.valueOf(kelval[1]));
				
			      }
			}
			
			
			
			}
		} catch (Exception e) {
			isRunning = false;
			System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
		}
		
		
	       }
		
		
		System.out.println(" CONSUMER : "+Thread.currentThread().getId()+" COMPLETED");
	}

}
