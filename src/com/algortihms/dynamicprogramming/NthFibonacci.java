package com.algortihms.dynamicprogramming;

public class NthFibonacci {

	long[] arr ;
	int number =0;
			
	
	public NthFibonacci(int number){
		this.number = number;
		arr = new long[number];
		
		for(int i=0;i<number;i++)
		{
			arr[i]=0;
		}
		
	}
	
	public   long fibonacci( int number){

		if(number ==0) return 0;

		if(number ==1) return 1;
		
		if(arr[number] == 0) arr[number] = fibonacci(number-1)+fibonacci(number-2);

		return arr[number];

		}
	
	

	
	public static void main(String[] args) {
            System.out.println(new NthFibonacci(100).fibonacci(85));
	}

}
