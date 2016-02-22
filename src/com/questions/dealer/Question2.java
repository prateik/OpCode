package com.questions.dealer;

import java.util.Locale;

public class Question2 {

	
	private static boolean isPalindrome(String str) { 
		
		str = str.replaceAll("[^A-Za-z0-9]","").toLowerCase(Locale.ENGLISH);
	    int n = str.length();
	    
	    for( int i = 0; i < n/2; i++ )
	        if (str.charAt(i) != str.charAt(n-i-1)) return false;
	    return true;    
	}
	
	public static void main(String[] args){
		
		String text = "Ah, Satan sees Natasha";
		
		System.out.println(isPalindrome(text));
		
	}
}
