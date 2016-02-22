package com.datastructures.array;

import java.util.Arrays;

public final class RemoveChars {
	
	
	public static char[] removeChars(char[] text,char[] del)
	{
		
		int destn = 0;
		
		
		for(int source = 0; source < text.length;)
		{
			
		for(char d:del)
		{
			if(text[source] == d)
			{
				source++;
			}
			else{
				text[destn] = text[source];
				source++;
				destn++;
			}
		}
			
		}
		

		return Arrays.copyOfRange(text, 0, destn);
		
	}
	

	public static void main(String[] args) {
		
     char[] result = removeChars(new char[]{'a','b','c'},new char[]{'a'});
     
     for(char c: result) System.out.print(c);
	}

}
