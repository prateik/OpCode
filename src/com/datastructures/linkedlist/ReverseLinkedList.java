package com.datastructures.linkedlist;

public class ReverseLinkedList {
	
	
	public static Node reverseLinkedlist(Node head)
	{
		
		Node prev = null;
		Node curr = head;
		Node next = null;
	
		
		while(curr != null)
		{
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}

		return prev;
	}
	

	public static void main(String[] args) {
	LinkedList ll = new LinkedList();
		
		ll.displayList();
		ll.addNode(10);
		ll.addNode(25);
		ll.addNode(5);
		ll.addNode(15);
		ll.addNode(5);
		
		ll.displayList();
		ll.head  = reverseLinkedlist(ll.head);
		
		
		ll.displayList();
	}

}
