package com.datastructures.linkedlist;

public class LoopDetection {

	
	
	public static boolean loopDetection(LinkedList list){
		
		
		Node slow = list.head;
		Node fast = list.head;
		
		if(fast.next == null) return false;
		
		while(fast.next != null && fast.next.next != null){
			
			
		    slow= slow.next;
		    fast = fast.next.next;
		    
		    if(slow == fast) return true;
			
		}
		

		return false;
	}
	
	public static void main(String args[]){
		
LinkedList ll = new LinkedList();
		
		ll.displayList();
		ll.addNode(10);
		ll.addNode(25);
		ll.addNode(5);
		ll.addNode(15);
		ll.addNode(17);
		
		Node loop = new Node(35);
		loop.next = ll.head;
		
		ll.addNode(loop);
		
		ll.displayList();
		
		
		System.out.println( " Loop detected: "+ loopDetection(ll));
	}
	
}
