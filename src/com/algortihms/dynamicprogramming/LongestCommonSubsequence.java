package com.algortihms.dynamicprogramming;

public class LongestCommonSubsequence {

	
	String word1;
	String word2;
	int[][] LCS;
	StringBuilder lcsString = new StringBuilder();
	public LongestCommonSubsequence(String word1,String word2) {
	   this.word1=word1;
	   this.word2=word2;
	   
	   LCS = new int[word1.length()][word2.length()];
	}
	
	
	
	public int LCS(){
		
		
		for(int i=0;i < word1.length();i++)
		{
		LCS[i][0]=0;
			
		}
		for(int i=0;i < word2.length();i++)
		{
		LCS[0][i]=0;
			
		}
		
		
		for(int i=1;i < word1.length();i++){
			
			for(int j=1;j < word2.length();j++){
				
				if(word1.charAt(i) == word2.charAt(j))
				{
					LCS[i][j]= 1+ LCS[i-1][j-1];
					lcsString.append(word1.charAt(i));
				}
				
				else{
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
				
			}
		}
		
		
		return LCS[word1.length()-1][word2.length()-1];
		
	}
	
	
	public void printLCSMAtrix(){
	for(int i=0;i < word1.length();i++){
			
			for(int j=0;j < word2.length();j++){
			
			System.out.print(LCS[i][j]+" | ");
			}
			System.out.println();
			}
		
		
		
	}
	
	
	public static void main(String ags[]){
		
		LongestCommonSubsequence lcs =new LongestCommonSubsequence(" abcde", " afghbkgicshjdytytyte");
		System.out.println(lcs.LCS());
		
		lcs.printLCSMAtrix();
		
		System.out.println(lcs.lcsString.toString());
		
		
	}

}
