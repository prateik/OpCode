package com.algorithms.dynamicprogramming;

public class NumberOFWaysNCents {

	
	
	public static int makechnage(int n)
	{
		
		int[] denoms = {25,10,5,1};
		return makeChange(n,denoms,0);
	}
	
	
	public static int makeChange(int amount,int[] denoms,int index){
		
		
		System.out.println("Amount : "+amount+ " denomination  : "+denoms[index]+ " index : "+index);
	
		if(index >= denoms.length-1) return 1;
	
	int denomAmount  = denoms[index];
	int ways = 0;
	
	for(int i=0;i * denomAmount <= amount;i++)
	{
		int amountRemaining = amount - i*denomAmount;
		ways += makeChange(amountRemaining, denoms, index+1);
	}
	
	return ways;
	}
	
	public static void main(String[] args) {
	
		System.out.println(makechnage(25));

	}

}
