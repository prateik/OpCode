package com.questions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

class Producer implements Runnable {

	protected BlockingQueue<String> queue = null;
	static String FileLocation = "/home/prateik/workspace/Data.txt";

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream(FileLocation);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				queue.put(line);
			}
            // adding poison pill
			queue.put("POISON_PILL");

			// handling scanner exceptions
			if (sc.ioException() != null) {
				try {
					throw sc.ioException();
				} catch (IOException e) {
					System.err.println("Excpetion occurred while adding String to queue" + e);
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException | InterruptedException e) {
			System.err.println("Excpetion occurred while adding String to queue" + e);
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.err.println("Excpetion occurred while adding String to queue" + e);
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue<String> queue = null;
	ConcurrentHashMap<String, Integer> hashmap;
	private volatile boolean isRunning = true;
	Pattern p = Pattern.compile("[a-zA-Z]+[,][0-9]+");
	private Lock queueLock = new ReentrantLock();

	public Consumer(BlockingQueue<String> queue, ConcurrentHashMap<String, Integer> hashmap) {
		this.queue = queue;
		this.hashmap = hashmap;
	}

	// method to validate an entry using the pattern p
	public boolean isValidEntry(String entry) {
		return p.matcher(entry).matches();
	}

	public void run() {

		while (isRunning) {
			try {

				String i = queue.take();

				if (i != null) {
					if (i.equals("POISON_PILL")) {

						// if poison pill is detected add it back to the queue and countdown latch
						queue.put(i);
						queueLock.lock();
						KeyCountProblem.latch.countDown();
						queueLock.unlock();
						break;

					} else {

						synchronized (this) {

							if (isValidEntry(i)) {
                                
								String[] kelval = i.split(",");
								if (hashmap.containsKey(kelval[0])) {
									hashmap.put(kelval[0], (hashmap.get(kelval[0]) + Integer.valueOf(kelval[1])));
								} else {
									hashmap.put(kelval[0], Integer.valueOf(kelval[1]));
								}

							}
						}
				}

				}

			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.println("Exception occurred while running consumer" + e);
				isRunning = false;
			}

		}
	}
}

public class KeyCountProblem {

	static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(500);
	static ConcurrentHashMap<String, Integer> hashmap = new ConcurrentHashMap<String, Integer>();
	static volatile boolean isRunning = true;
	public static final int NoOfConsumerThreads = 20;

	static CountDownLatch latch = new CountDownLatch(NoOfConsumerThreads);
	public static volatile boolean allTasksSubmitted = false;
	public static ExecutorService executorService = Executors.newFixedThreadPool(NoOfConsumerThreads);
	public static long start;
	public static long end;

	public static void main(String[] args) {

		start = System.currentTimeMillis();
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue, hashmap);

		new Thread(producer).start();

		for (int i = 0; i < NoOfConsumerThreads; i++) {
			executorService.submit(consumer);
		}
		// System.out.println("CONSUMERS SUBMITTED..");

		try {
			latch.await();
		} catch (InterruptedException e) {
			System.err.println("Exception occurred while running" + e);
			e.printStackTrace();
		}
		// printHashMap();
		KeyCountProblem.shutdownExecutor();
	}

	public static void shutdownExecutor() {

		if (executorService != null || !executorService.isShutdown()) {
			executorService.shutdown();

			try {
				executorService.awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				System.err.println("Excpetion occurred while shutting down" + e);
				e.printStackTrace();
			}
		}
		printHashMap();
		KeyCountProblem.end = System.currentTimeMillis();

	}

	public static void printHashMap() {
		if(hashmap.isEmpty() || hashmap.size() == 0){
			System.out.println(" Hashmap is Empty");
		}
		else{
		for (Entry<String, Integer> map : hashmap.entrySet()) {
			System.out.print("The total for " + map.getKey() + " is " + map.getValue() + ".");
		}}
	}

}