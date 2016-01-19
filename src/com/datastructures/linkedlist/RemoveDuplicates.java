package com.datastructures.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {
	
	
	public static Node removeDuplicates(Node node){
		
		if (node == null) return null;
		
		HashSet <Integer> set = new HashSet<Integer>();
		
		Node curr = node;
		Node prev = node;
		
		while(curr.next != null){
			
			if(set.contains(curr.data)){
				//System.out.println("Duplicate detected ..");
				prev.next=curr.next;
				curr=curr.next;
			}
			
			else{
				//System.out.println("new element..adding to buffer");
				set.add(curr.data);
				prev=curr;
				curr=curr.next;
			}
		}
		
       return node;
		
	}

	public static void main(String args[]){
		
		
		LinkedList ll = new LinkedList();
		
		ll.displayList();
		ll.addNode(10);
		ll.addNode(25);
		ll.addNode(5);
		ll.addNode(15);
		ll.addNode(5);
		ll.displayList();
		ll.head = removeDuplicates(ll.head);
		ll.displayList();
	}
	

}
