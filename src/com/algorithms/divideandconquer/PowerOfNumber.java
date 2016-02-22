package com.algorithms.divideandconquer;

public class PowerOfNumber {
	
	public static int pow(int x,int n)
	{
		
		if(n == 0) return 1;
		if(n == 1) return x;
	
		return x*pow(x,n-1);
		
	}
	
	
	public static int pow2(int x,int n)
	{
		
		int temp ;
		if(n == 0) return 1;
		if(n == 1) return x;
	
		
		temp = pow2(x,n/2);
		if(n%2==0) return temp*temp; 
		return x*temp*temp;
		
	}
	

	public static void main(String args[]){
    
	System.out.println(pow(2,50));
	
	System.out.println(pow2(2,50));
	
		
	}

}
