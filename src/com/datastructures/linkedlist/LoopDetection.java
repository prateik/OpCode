package com.datastructures.linkedlist;

public class LoopDetection {

	
	
	public void loopDetection(){
		
		
		
	}
	
	public static void main(String args[]){
		
LinkedList ll = new LinkedList();
		
		ll.displayList();
		ll.addNode(10);
		ll.addNode(25);
		ll.addNode(5);
		ll.addNode(15);
		ll.addNode(17);
		ll.displayList();
		ll.deleteNode(5);
		ll.displayList();
		ll.deleteNode(10);
		ll.displayList();
	}
	
}
