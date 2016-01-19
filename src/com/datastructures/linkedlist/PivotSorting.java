package com.datastructures.linkedlist;

public class PivotSorting {
	
	
	public static Node sortByPivot(Node node,int pivot){
		
		LinkedList lower = new LinkedList();
		LinkedList higher = new LinkedList();
		
		
		Node curr=node;
		
		
		while(curr != null){
			
			if(curr.data < pivot){
				System.out.println("Adding to lower"+curr.data);
				lower.addNode(curr.data);
			}
			
			else if(curr.data > pivot) {
				System.out.println("Adding to higher"+curr.data);
				higher.addNode(curr.data);
			}
			curr = curr.next;
		}
		
		Node temp =lower.head;
		
		
		while(temp.next!= null){
			temp=temp.next;
		}
		
		Node pivotNode= new Node(pivot);
		temp.next = pivotNode;
		pivotNode.next=	higher.head;
		
		return lower.head;
		
	}
	
	
	

	public static void main(String args[]){
		
		LinkedList ll = new LinkedList();
		
		ll.displayList();
		ll.addNode(10);
		ll.addNode(25);
		ll.addNode(5);
		ll.addNode(15);
		ll.addNode(20);
		ll.displayList();
		//ll.deleteNode(5);
		ll.displayList();
		ll.displayList();
		
		ll.head = sortByPivot(ll.head, 20);
		
		ll.displayList();
		}
	
}
