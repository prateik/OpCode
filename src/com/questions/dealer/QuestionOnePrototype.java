package com.questions.dealer;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;



class Producer implements Runnable {

	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {

		try {
             System.out.println("START LOADING TASKS..");
			for (int i = 0; i < 100000; i++) {
				queue.put(i);
				 //System.out.println("Producer ID "+Thread.currentThread().getId()+" is adding task : "+i);
			}
			// poison pill
			// System.out.println("Poison number added! "+Thread.currentThread().getId());
			queue.put(-1);
			 System.out.println("SIGNAL SHUTDOWN");
			QuestionOnePrototype.shutdownExecutor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue queue = null;
	ConcurrentHashMap<Integer, Integer> hashmap;
	private volatile boolean isRunning = true;

	public Consumer(BlockingQueue queue,
			ConcurrentHashMap<Integer, Integer> hashmap) {
		this.queue = queue;
		this.hashmap = hashmap;
	}

	public void run() {

		while (isRunning) {
			try {
				Integer i = (Integer) queue.take();

				//System.out.println("Consumer " + Thread.currentThread().getId()+ ": taking Task : " + i);

				if (i == null) {
					isRunning = false;
				}
				
				else{

				if (i == -1) {
					queue.put(i);
					isRunning = false;
			
					// System.out.println("Setting isRunning to false :  "+Thread.currentThread().getId());

				} else {
					hashmap.put(i, i);
					//System.out.println("Adding data to hashmap :  "+Thread.currentThread().getId());
				}}

			} catch (InterruptedException e) {
				e.printStackTrace();
				isRunning = false;
			}
		}
		
		System.out.println("CONSUMER : "+Thread.currentThread().getId()+" COMPLETED!");
	}
}

public class QuestionOnePrototype {

	static BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
	static ConcurrentHashMap<Integer, Integer> hashmap = new ConcurrentHashMap<Integer, Integer>();
	static volatile boolean isRunning = true;
	public static final int NoOfConsumerThreads = 5;
	public static volatile boolean allTasksSubmitted = false;
   public static ExecutorService executorService = null;
	public static void main(String[] args) {

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue, hashmap);

		new Thread(producer).start();
		executorService = Executors.newFixedThreadPool(NoOfConsumerThreads);
		for (int i = 0; i < NoOfConsumerThreads; i++) {
			executorService.execute(consumer);
		}
		System.out.println("CONSUMERS SUBMITTED..");
	}
	
	
	public static void shutdownExecutor(){
		executorService.shutdown();
		System.out.println("SHUTTING DOWN THREAD POOL");
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printHashMap();
	}

	public static void printHashMap() {
		System.out.println("HASHMAP SIZE : " + hashmap.size());
		
		/*for (Map.Entry<Integer, Integer> map : hashmap.entrySet()) {
			System.out.println("Entry " + map.getKey() + ":" + map.getValue());
		}*/
	}

}