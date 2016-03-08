package com.datastructures.string;

import java.util.Scanner;

/**
 * Pangrams are sentences constructed by using every letter of the alphabet at least once.)
 * @author prateik
 *
 */
public class Pangrams {
	
	
	public static boolean isPangram(String text){
		
		
		if(text == null || text.trim().equals("") || text.length() < 26) return false;
		
		boolean[] alphabetFlags = new boolean[26];
		

		for(int i=0;i< 26;i++)
		{
			alphabetFlags[i] = false;
		
			
		}
		
		for(int i=0;i< text.length();i++)
		
		{
			if(text.toLowerCase().charAt(i)-'a'  >= 0 &&text.toLowerCase().charAt(i)-'a' < 26 ){
				
				alphabetFlags[(text.toLowerCase().charAt(i)-'a')]=true;
			}
			
		}
		
		
		for(int i=0;i< 26;i++)
		{
			if(alphabetFlags[i] == false)
				return false;
			
		}
		
		return true;
	}
	
	public static void main(String... args)
	{
		
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		//String text ="The quick brown fox jumps over the lazy dog";
	
		
		if(isPangram(text)) System.out.println("pangram");
		else System.out.println("not pangram");
		
	}

}
