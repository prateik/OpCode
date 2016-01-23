package com.datastructures.linkedlist;

public class SumOfLists {
	
	
	
	public static  LinkedList findSum(LinkedList numhead1,LinkedList numhead2){
		
		LinkedList sum = new LinkedList();
		Node num1Pointer  = numhead1.head;
		Node num2Pointer = numhead2.head;
		int carry = 0;
		
		while(num1Pointer != null || num2Pointer != null){
			
			int tempSum = 0;
			
			if(carry == 1){tempSum++;}
			
			if(num1Pointer != null){
			
				tempSum+=num1Pointer.data;
			}
			
			if(num2Pointer != null){
				tempSum+=num2Pointer.data;
			}
			
			
			if(tempSum > 9){
				carry = 1;
				tempSum-=10;
			}
			else{
				carry = 0;
			}
			
			
			System.out.println("temp sum = "+tempSum+" carry ="+carry);
			sum.addNode(tempSum);
			
			if(num1Pointer != null){
			num1Pointer = num1Pointer.next;
			}
			
			if(num2Pointer!= null){
			num2Pointer = num2Pointer.next;
			}
			
		}
		
		
		if (carry == 1){
			sum.addNode(1);
		}
		
		return sum;
	}
	
	
	
	
	
	public static void main(String args[]){
		
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
		
		ll1.addNode(9);
		ll1.addNode(9);
		ll1.addNode(9);
		ll2.addNode(1);
		ll2.addNode(1);
		LinkedList ll3= findSum(ll1,ll2);
		ll3.displayList();
		
	}

}
