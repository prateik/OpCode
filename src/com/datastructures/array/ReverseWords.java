package com.datastructures.array;

import java.util.Stack;

public class ReverseWords {

	
	public static char[] reverseWords(char[] text)
	{
		
		for(char c: text) System.out.print(c);
		System.out.println();
		
		
		for(int i=0;i< text.length/2;i++)
		{
			char temp = text[i];
			text[i]= text[text.length-i-1];
			text[text.length-1-i]=temp;
		}
		
		for(char c: text) System.out.print(c);
		System.out.println();
		
		int counter = 0;
		int wordSize = 0;
		int wordStart = 0;
		Stack<Character> stack = new Stack<Character>();
		
		while(counter < text.length)
		{
			if(text[counter]!= ' ' ){
				//System.out.println("Adding to stack : "+text[counter]);
				stack.push(text[counter]);
				wordSize++;
				
			}
			
			
			if(counter+1 == text.length || text[counter] == ' ' )
			
			{
				//System.out.println(" Word Size : "+wordSize+ " wordstart : "+wordStart);
				
				
				for(int i = wordStart;i < wordStart+wordSize;i++)
				{
					text[i]=stack.pop();
					//System.out.println("Added "+text[i]+ " to "+i);
				}
				
				if(wordStart+wordSize != text.length){
				text[wordStart+wordSize]=' ' ;}
				wordStart = wordStart+wordSize;
				wordStart++;
				wordSize = 0;
				
			}
			
			
			
			counter++;
			
		}
		
		return text;
	}
	
	public static void main(String[] args) {
		char[] rev = reverseWords(new char[] {'h','2','3',' ','a','1','a','2','a',' ','t','4'});
		
		for(char c: rev) System.out.print(c);
	}

}
