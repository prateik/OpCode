package com.datastructures.linkedlist;


class GenericNode <T>{
	
	T data;
	GenericNode next;
	
	public GenericNode(T data)
	{
		this.data = data;
		this.next = null;
	}
	
 }
public class GenericLinkedList<T> {

	GenericNode<T> head = null;
	
	
	public void addNode(T data)
	{
		GenericNode<T> node = new GenericNode<T>(data);
		
		if(head == null){
			head = node;
		}
		else{
            node.next = head;
            head = node;
		}
	   
	}
	
	
	public void printLinkedList(){
		
		GenericNode<T> curr = head;
		while(curr != null)
		{
			
			System.out.print(curr.data+ "-> ");
			curr = curr.next;
			
		}
		System.out.println();
	}
	public static void main(String[] args) {

		
		GenericLinkedList<Integer> numLinkedList = new GenericLinkedList<Integer>();
		
		numLinkedList.addNode(10);
		numLinkedList.addNode(25);
		numLinkedList.addNode(30);
		numLinkedList.addNode(45);
	
		numLinkedList.printLinkedList();
	   GenericLinkedList<String> stringLinkedList = new GenericLinkedList<String>();
	   
	   stringLinkedList.addNode("hello");
	   stringLinkedList.addNode("hi");
	   stringLinkedList.addNode("hey");
	   
	   stringLinkedList.printLinkedList();
	
	}
	
	

}
