package com.datastructures.string;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeated {

	
	
	public static char getFirstNonRepeatedChar(String text){
		char[] textArray = text.toCharArray();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for(char c:textArray){
			
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			
			else{
				//System.out.println("adding :"+c);
				map.put(c,1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			//System.out.println(" entry :"+entry.getKey()+":"+entry.getValue());
		}
		
		
		
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			if(entry.getValue() == 1) return entry.getKey();
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(getFirstNonRepeatedChar("totafghdfghhzsorjfjfjal"));

	}

}
