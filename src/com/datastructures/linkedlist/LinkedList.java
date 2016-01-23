package com.datastructures.linkedlist;



class Node {
	
	int data;
	Node next;
	
	
	Node(int data){
		this.data = data;
	}
}
public class LinkedList {

	Node head = null;
	
	
	public Node addNode(int data){
		
		if(head == null){
			head = new Node(data);
		
		}
		
		else{
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
		}
		
		return head;
		
	}
	
	
public Node addNode(Node node){
		
		if(head == null){
			head = node;
		
		}
		
		else{
			Node temp = node;
			temp.next = head;
			head = temp;
		}
		
		return head;
		
	}
	
	public void displayList (){
		
		if(head == null)
		{
			System.out.println("The List is empty!");
		}
		
		else{
			Node curr = head;
			
			while(curr != null){
				
			System.out.print(curr.data+" -> ");
			curr = curr.next;
						
			}
			
		}
		
		System.out.println();
		
	}
	
	
	
	public void deleteNode(int data){
		
		if (head == null){
			System.out.println("List is empty! cannot delete!");
			return;
		}
		
		else{
			
			Node curr = head;
			Node prev = head;
			
			while(curr != null){
				if (curr.data == data){
					prev.next = curr.next;
				}
				
				prev = curr;
				curr = curr.next;
			}
			
		}
		
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
	}
	
}
