package com.datastructures.stack;

public class KStacks {

	int[] stackData;
	int[] stackIndex;
	
	int nextFreeIndex;
	int[] stackPointers;
	
	
	
	public KStacks(int numberOfStacks,int totalSize){
		
		stackData = new int[totalSize];
		stackIndex = new int[totalSize];
		
		nextFreeIndex = 0;
		stackPointers = new int[numberOfStacks];
		
		for(int i=0;i<stackIndex.length;i++){
			stackIndex[i]= i+1;
		}
		
	}
	
	
	public void push(int data,int stackNumber){
		
		// store data
		stackData[nextFreeIndex] =  data;
		
		//store prev index as stack index value
		stackIndex[stackNumber] = stackPointers[stackNumber];
		
		//store the next free index as the new top for that stack
		stackPointers[stackNumber] = nextFreeIndex;
		
		nextFreeIndex++;
		
	}
	
	
	public int pop(int stackNumber){
		
		int poppedIndex = stackPointers[stackNumber];
		nextFreeIndex=stackIndex[stackPointers[stackNumber]];
		stackIndex[nextFreeIndex]=poppedIndex;
		//stackPointers[stackNumber]=n
		
		return 0;
	}
	
	
	
	public static void main(String args[]){
		
		
		
		
	}
}
