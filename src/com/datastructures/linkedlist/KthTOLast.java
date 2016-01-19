package com.datastructures.linkedlist;

public class KthTOLast {

	public static Node kThToLast(Node node,int K){
		
		Node kNode = node;
		Node curr =node;
		int k = 1;
		
		
		while(curr.next != null){
			
			if(k < K){
				curr =curr.next;
				k++;
			}
			else{
				kNode = kNode.next;
				curr = curr.next;
				
			}
			
		}
		
		
		return kNode;
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
	//ll.deleteNode(5);
	ll.displayList();
	//ll.deleteNode(10);
	ll.displayList();
		Node kthNode = kThToLast(ll.head, 2);
		System.out.println(kthNode.data);
		
		ll.displayList();
	}
	
}
