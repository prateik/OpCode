package com.datastructures.stack;

public class StackWithArray {

    int [] stack;
	int stackTopIndex;
	
    public StackWithArray(int stackSize){
		stack = new int[stackSize];
		stackTopIndex = -1;
	}
	
	public void push(int data){
		
		if(stackTopIndex < stack.length-1)
		  {
			stackTopIndex++;
		  stack[stackTopIndex] = data;
		  
		  }
		else{
			System.out.println("Stack is Full!");
		}
		
		//System.out.println("Index : "+stackTopIndex);
	    }
	
	
	public void pop (){
		
		if(stackTopIndex >= 0)
		{
			stackTopIndex--;
		}
		
		else{
			System.out.println("Stack is Empty !");
		}
		
		//System.out.println("Index : "+stackTopIndex);
	}
	
	
	
	public int peek(){
	
		
		if(stackTopIndex >= 0){
		return stack[stackTopIndex];
		}
		
		else{
			System.out.println("Stack is Empty!");
			return -1;
		}
	}
	
	
	
	public void stackTrace(){
		for(int i=0;i< stack.length;i++){
			
			System.out.print(" "+stack[i]+" | ");
		}
		
		System.out.println();
	}
	
	public static void main(String args[]){
		
		StackWithArray stack = new StackWithArray(5);
		
		stack.push(10);
		stack.push(25);
		stack.stackTrace();
		System.out.println(stack.peek());
		stack.pop();
		stack.stackTrace();
		System.out.println(stack.peek());
		stack.push(9);
		stack.push(8);
		stack.push(33);
		stack.stackTrace();
		stack.push(57);
		stack.stackTrace();
		
	}
	
	
}
