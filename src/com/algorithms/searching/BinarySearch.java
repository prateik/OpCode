package com.algorithms.searching;

public class BinarySearch {
	
	
	
	public static int binarySearch(int[] array,int low,int high,int element)
	{
		int mid = (low+high)/2;
		
		if(high < low) return -1;
		
		if(array[mid]==element) return element;
		else if(element < array[mid]) high = mid-1;
		else low = mid+1;
		
		return binarySearch(array, low, high, element);
		
	}
	
	public static String binarySearchString(String[] strings,int low,int high,String element){
		
		
		int mid=(low+high)/2;
		
		
		if(high < low) return null;
		
		if(strings[mid].equals(element)) return element;
		
		else if(strings[mid].compareTo(element) > 0) 
			return binarySearchString(strings, low, mid-1, element);
		
		else return binarySearchString(strings, mid+1, high, element);
	}

	public static void main(String[] args) {
		
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(binarySearch(array, 0, array.length-1, 55));
		
		
		String[] stringArray = {"abb","abc","abd","abe","abf"};
		System.out.println(binarySearchString(stringArray, 0, stringArray.length-1, "abb"));

	}

}
