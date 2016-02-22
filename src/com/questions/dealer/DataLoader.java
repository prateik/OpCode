package com.questions.dealer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class DataLoader implements Runnable{

	
	static String FileLocation ="/home/prateik/workspace/Data.txt";
	public  BlockingQueue<String> queue;
	
	
	public DataLoader(BlockingQueue<String> q) {
		queue = q;
	}
	

	public void run(){
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream(FileLocation);
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        // System.out.println("ADDING : "+ line);
		         queue.put(line);
		    }
		    
		    queue.put("QUEUE_END");
		    System.out.println("PRODUCER TASK COMPLETE ");
		   
		    // note that Scanner suppresses exceptions
		    if (sc.ioException() != null) {
		        try {
					throw sc.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		} catch (FileNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}

	
	public static void main(String[] args) {
		//loadDataFile();
	}


}
