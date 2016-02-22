package com.questions.dealer;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class KeySumDriver {

	 BlockingQueue<String> q = new LinkedBlockingQueue<String>(50);
	  Hashtable<String, Integer> results = new Hashtable<String, Integer>();
	 static ExecutorService executorService = null;
	 static KeySumDriver keySum = null;
	public  void printHashMap() {
		System.out.println(" Printing Table size: "+this.results.size());
		
		for (Map.Entry<String, Integer> entry : results.entrySet())
			System.out.println("The total for " + entry.getKey() + " is " + entry.getValue());

	}

	public static void main(String[] args) {

		 executorService = Executors.newFixedThreadPool(1);
         KeySumWorker keySumWorker = new KeySumWorker(keySum.q, keySum.results);
         DataLoader dataLoader = new DataLoader(keySum.q);
         new Thread(dataLoader).start();
        try {

       	
			for (int i = 0; i < 3; i++) {
				keySum.executorService.execute(keySumWorker);

			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        
		
	}

	public static void shutdownExecutor() {
	
		System.out.println("SHUTTING DOWN EXECUTOR");
		keySum.executorService.shutdown();
		
		try {
			keySum.executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//printHashMap();
	}

}
