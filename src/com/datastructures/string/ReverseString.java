package com.datastructures.string;

public class ReverseString {

	
	
	public static String reverse(String text){
		
		if(text == null || text.trim().equals("")){
			return null;
		}
		StringBuffer revText = new StringBuffer();
		
		
		for(int i = text.length()-1;i >= 0;i--)
		{
			revText.append(text.charAt(i));
		}
		
		return revText.toString();
	}
	
	
	public static String reverse2(String text){
		
		char[] textChars = text.toCharArray();
		for(int i=0; i < text.length()/2;i++){
			char tempChar = textChars[text.length()-1- i];
			textChars[text.length()-1 - i]= textChars[i];
			textChars[i]= tempChar;
			
		}
		System.out.println(textChars);
		return textChars.toString();
	}
	
	
	public static void main(String args[]){
		
		System.out.println(reverse2("abcdef"));
		
	}
	
	
}
