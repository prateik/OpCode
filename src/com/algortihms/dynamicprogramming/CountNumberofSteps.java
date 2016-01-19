package com.algortihms.dynamicprogramming;

public class CountNumberofSteps {

	
	public static int countNumberOfWays(int n){
		
		if(n == 0) return 1;
		if(n == 1) return 1;
		if (n == 2) return 2;
		if (n ==3) return 4;
		return countNumberOfWays(n-1)+countNumberOfWays(n-3)+countNumberOfWays(n-2);
	}
	
	
	

	public static int countNumberOfWays2(int n,int [] map){
		
		if(n == 0) return 1;
		if(n == 1) return 1;
		if (n == 2) return 2;
		if (n ==3) return 4;
		
		if(map[n] > 0) return map[n];
		map[n]=countNumberOfWays(n-1)+countNumberOfWays(n-3)+countNumberOfWays(n-2);
	
	  return map[n];
	}
	
	
	public static void main(String[] args) {

		int[] array = new int[37];
		
		System.out.println(countNumberOfWays2(36,array));
		System.out.println(countNumberOfWays(36));
		
	}

}
