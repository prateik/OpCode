package com.datastructures.queue;

public class QueueWithArray {

	
	  int[] queue;
	  int topIndex;
	  int bottomIndex;
	  int N;
	  
	  public QueueWithArray(int QueueSize){
		  
		  queue = new int[QueueSize];
		  topIndex = 0;
		  bottomIndex = 0;
		  N=0;
	  }
	
	public void enqueue(int item){
		
		if(N == queue.length) {
			System.out.println("Queue if Full!");
			return;
		}
		
		queue[bottomIndex++]=item;
		
		//System.out.println(" Added element "+item+" at index :"+(bottomIndex-1));
		
		if(bottomIndex == queue.length) bottomIndex=0;
		N++;
		
	}
	
	
	public int dequeue(){
		
		if(N == 0){
			System.out.println("Queue is Empty!");
			return -1;
		}
		
		N--;
		int item = queue[topIndex++];
		
		if(topIndex == queue.length) topIndex=0;
		
		return item;
	}
	
	public boolean isEmpty(){
		
		return N == 0;
	}
	

	public void printQueue(){
		
		
		if(N ==  0){
			
			System.out.println(" Queue is Empty!");
			return;
		}
		
		int tempSize = N;
		int tempIndex = topIndex;
		
		while(tempSize > 0){
			
			System.out.print(queue[tempIndex]+" | ");
			tempIndex++;
			if(tempIndex == queue.length) tempIndex = 0;
			
			tempSize--;
		}
		
		System.out.println();
		
		
	}
	public static void main(String[] args) {

		QueueWithArray queue = new QueueWithArray(5);
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(50);
		
		queue.printQueue();
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();	
		queue.dequeue();
		
		
		queue.printQueue();
		
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);
		queue.enqueue(100);
		
		
		queue.dequeue();
		queue.dequeue();	
		queue.dequeue();
		
		queue.printQueue();
		
	}

}
