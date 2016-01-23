package com.misc;

import java.util.Arrays;
import java.util.List;

public class AlphaNumericGenerator {
	
	
	
	public static void main(String args[]){
		
		 final List<Character> numberset = Arrays.asList(		
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
		);
		
		
		 for(int i =0;i< numberset.size();i++)
		 {
			 
			 for(int j=0;j <  numberset.size();j++){
				 
				 String subject = ""+numberset.get(i)+numberset.get(j);
				 
				 System.out.println(subject);
				 
			 }
			 
			 
		 }
		 
		 
		
	}

}
