package com.datastructures.string;

public class Atoi {
	
	
	
	public static int atoi(String number)
	{
		int num =0;
		
		for(int i=0;i< number.length();i++)
		{
			num += Character.getNumericValue(number.charAt(number.length()-1-i))* Math.pow(10, i);
		}
		
		return num;
		
	}
	
	public static void main(String args[]){
		
		System.out.println(atoi("9877383"));
		
	}

}
