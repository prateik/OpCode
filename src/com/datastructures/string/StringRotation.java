package com.datastructures.string;

public class StringRotation {

	
	public static boolean isRotation(String s1,String s2){
	
		String text = s2+s2;
		
		if(text.contains(s1)) return true;
		
		return false;
	}
	
	public static boolean isRotationUsingBuilder(String s1,String s2){
		
		StringBuilder text = new StringBuilder();
		
		text.append(s2);
		text.append(s2);
			
		if(text.toString().contains(s1)) return true;
		
		return false;
	}
	
	
	public static void main(String args[]){
		
		System.out.println(isRotation("text", "ttex"));
	}
}
