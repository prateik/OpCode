package com.algorithms.dynamicprogramming;

/*Substring : A pattern P is called a substring of Text T if the pattern appears in the Text in a continuous fashion.

Subsequence : A pattern P is called a subsequence of Text T if the pattern preserves the relative ordering of characters within the text T and it might not appear in a continuous fashion. 

* Approach : generate a 2d array and 
*
*/


public class LargestCommonSubstring {

	char Array[][];
	
	
	public static String getLongestCommonSubString(String text1,String text2){
	
		
		int max= 0;
	    String result = null;
	   int[][] lcs = new int[text1.length()][text2.length()];
	   
	   
	   for(int i=0;i < text1.length();i++){
		   
		   for(int j=0;j < text2.length();j++){
			   
			   
			   if(text1.charAt(i)==text2.charAt(j))
			   {
				   if(i-1 > 0 && j-1 >0){
				   lcs[i][j] = 1+lcs[i-1][j-1];
				   }
				   else lcs[i][j] = 1;
				   
			   }
			   
			  if(lcs[i][j] > max)
			  {
	              max = lcs[i][j];			  
				  result = text1.substring(i-max+1, i+1);
			  }
			   
			   
		   }
	   }
	   
	   
         for(int i=0;i < text1.length();i++){
		   
		   for(int j=0;j< text2.length();j++){
			   
			   
			  System.out.print(lcs[i][j] + " | " );
			   
		   }
		
	    System.out.println();
 	    }
	
	
	return result;
	}
	
	public static void main(String[] args) {
	String text1 = "text1text1text1";
	String text2 = "text2text2text2";
	System.out.println(getLongestCommonSubString(text1, text2));
	
	

	}

}
