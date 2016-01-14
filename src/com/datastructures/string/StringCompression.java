package com.datastructures.string;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


class Node{
	
	char c;
	int number;
	
	
	
	Node(char c,int val){
		this.c=c;
		this.number=val;
	}
}


public class StringCompression {
	
	public static String compress(String text){
		
		Map<Character,Integer> data = new LinkedHashMap<Character,Integer>();
		
		
		for(Character c:text.toCharArray()){
			
			if(data.containsKey(c)){
				data.put(c,data.get(c)+1);
			}
			
			else{
				data.put(c,1);
			}
		}
		
		return data.toString();
		
	
	}
	
	
public static String compress2(String text){
		
		StringBuffer data = new StringBuffer();
		
    	char prev = text.charAt(0);
    	int count =1;
    	
    	for(int i = 1;i< text.length();i++){
    		
    		
    		if(prev == text.charAt(i)){
    			count++;
    		}
    		
    		else{
    			data.append(""+prev+count);
    			prev = text.charAt(i);
    			count=1;
    		}
    		
    	}
    
    	data.append(""+prev+count);
		
    	if(data.length() > text.length()){return text;}
		return data.toString();
		
	
	}
	
	
	
	
	public static void main(String args[]){
		
		
		System.out.println(compress2("abiiiii"));
		
	}

}
