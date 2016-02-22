package com.datastructures.queue;

import com.datastructures.linkedlist.LinkedList;

public class QueueWithLinkedlist {

	int topIndex = 0;
	int bottomIndex = 0;
	
	
	LinkedList queue = new LinkedList();
	
   public void enqueue(int item){
	
	    queue.addNode(item);

	}
	
	
	public int dequeue(){
	
	if(queue.head == null) {
		System.out.println(" Queue is Empty!");
		return -1;
	}
		
	 int item = queue.head.data;
	 queue.head = queue.head.next;
	 return item;
	}
	
	public boolean isEmpty(){
		
		return queue.head == null;
	}
	

	public void printQueue(){
		
		queue.displayList();
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		QueueWithLinkedlist qll = new QueueWithLinkedlist();
		
		qll.enqueue(10);
		qll.enqueue(20);
		qll.enqueue(30);
		qll.enqueue(40);
		qll.enqueue(50);
		qll.printQueue();
		qll.dequeue();
		qll.dequeue();
		qll.dequeue();
		qll.dequeue();
		qll.dequeue();
		qll.dequeue();
		qll.dequeue();
		qll.dequeue();
		qll.printQueue();

	}

}
