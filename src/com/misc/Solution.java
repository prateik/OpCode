package com.misc;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	
	//algorithmic complexity: 
	//memory requirements: 
	
	
	
	public  void reformat(String[] phoneNumbers){
		
		//input validation
		if(phoneNumbers == null || !(phoneNumbers.length > 0) ) return;
		
		//iterate through all the phoneNumbers
		
		for(int i=0;i< phoneNumbers.length;i++){
			
			
			//to build a new phone number 
			StringBuilder newPhoneNumber = new StringBuilder();
			
			System.out.println(phoneNumbers[i]);
			
			//for the format type with the "-"
			if(phoneNumbers[i].contains("-")){
				newPhoneNumber.append(phoneNumbers[i].substring(4,7));	
				newPhoneNumber.append("-");
				newPhoneNumber.append(phoneNumbers[i].substring(0,3));	
				newPhoneNumber.append("-");
				newPhoneNumber.append(phoneNumbers[i].substring(8,12));	
			}
			//the other format
			
			else{
				
				newPhoneNumber.append(phoneNumbers[i].substring(3,6));	
				newPhoneNumber.append("-");
				newPhoneNumber.append(phoneNumbers[i].substring(0,3));	
				newPhoneNumber.append("-");
				newPhoneNumber.append(phoneNumbers[i].substring(6,10));	
				
			}
			
			phoneNumbers[i]=newPhoneNumber.toString();
			System.out.println(phoneNumbers[i]);
		}
		
		
	}
	
	
	 class Person{
	
		 
		 String name;
		 String phoneumber;
	}
	
	
	public Person lookUpByPhoneNumber(String phoneNumber){
		
		List<Person> people =new ArrayList<Person>();
		
		
		//thread safe implementation
		synchronized(this){
		
			
			//input validation
		if(phoneNumber == null || phoneNumber.trim().equals(""))  return null;
		
		//iterate through the list of people 
		for(Person p:people){
			
			
			if(p.phoneumber.equals(phoneNumber)){
				return p;
			}
			
		}
		// no match found
		return null;	
		}
		
	}
	
	
	
        public void deletePerson(Person person){
		
        	List<Person> people =new ArrayList<Person>();
        	
        	// thread safe with lock on this object
        	synchronized(this){
        	if(person == null) return;
        	
              people.remove(person);
        	}
	    }
	
	
	
	public static void main(String[] args) {
		
		String[] array = {"1112223333"};
		//reformat(array);
		
		int a =-100;
		int b=-5;
		int x=-10;
		int y=-10;
		
		
		// Bug 01; use OR instead of AND
		while(a !=x || b!= y){
			
			// Bug 02: if a is lesser than x , a should be incremented
			if(a<x) a++;
			// Bug 03: do not increment or decrement if a==x
			else if(a == x){}
			else a--;
			
			if(b > y) b--;
			// Bug 04: do not increment or decrement if b==y
			else if (b == y){}
			else b++;
		}
		
		
		System.out.println(a);
		
		System.out.println(b);
		
		
		
		
		
		
		
		
		
		

	}

}
