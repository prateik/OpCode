package com.datastructures.string;

import java.util.Scanner;

/**
 * 
 * Suppose you have some string SS having length NN that is indexed from 00 to N−1N−1. 
 * You also have some string RR that is the reverse of string SS.
 *  SS is funny if the condition | S[j]−S[j−1] |=| R[j]−R[j−1] || S[j]−S[j−1] |=| R[j]−R[j−1] | is true
 *   for every jj from 11 to N−1N−1.




 * @author prateik
 *
 */
public class FunnyString {
	
	
	
	public static boolean isFunnyString(String text)
	
	{
		
		if(text == null || text.trim().equals("")) return false;
		
		for(int i=1;i< text.length();i++){
		
		if(Math.abs(text.charAt(i)-text.charAt(i-1))
				!= Math.abs(text.charAt(text.length()-i)-text.charAt(text.length()-i-1))) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		in.nextLine();
		//System.out.println(" T = "+T);
		for(int i=0;i < T;i++)
		{
			String text = in.nextLine();
			
			if(isFunnyString(text)) System.out.println("Funny");
			else System.out.println("Not Funny");
		}
		
		
		
	}

}
