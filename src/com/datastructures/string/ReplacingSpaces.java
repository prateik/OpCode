package com.datastructures.string;

public class ReplacingSpaces {

	
	public static char[] replaceSpaces(char[] text){
		
		
		int spaceCount = 0; 
		for(int i =text.length-1 ; i>=0 ;i--){
			if (text[i]==' ')
			{
				spaceCount++;
			}
		}
		int numShift = spaceCount * 2;
		
		for(int i =text.length-1 ; i>=0 ;i--){
			
			
			if (text[i]==' ')
			{
				text[i+numShift] = '0';
				text[i+(--numShift)] = '2';
				text[i+(--numShift)] = '%';
			}
			else{
				text[i+(--numShift)]=text[i];
			}
		}
		
		return text;
	}
	
	
	public static void main(String args[]){
		char [] text = new char[10];
		text[0]='h';
		text[1]='e';
		text[2]=' ';
		text[3]='l';
		text[4]=' ' ;
		text[5]='o';
		System.out.print(replaceSpaces(text));
	}
}
