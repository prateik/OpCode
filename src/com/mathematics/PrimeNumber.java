package com.mathematics;

public class PrimeNumber {

	public static boolean isPrime(int number){

		if(number <= 1 ) return false;

		for(int i = 2;i < number/4;i++)
		{
		  if(number%i == 0) return false;
		}

		return true;

		}

	
	public static void main(String args[]){
		
		System.out.println(isPrime(151));
		
	}
	
	
}
