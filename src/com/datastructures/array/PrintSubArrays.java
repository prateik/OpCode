package com.datastructures.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;




public class PrintSubArrays {
	
	
	
	// Prints all subarrays in arr[0..n-1]
	public static void subArray(int arr[], int n)
	{
	    // Pick starting point
	    for (int i=0; i <n; i++)
	    {
	        // Pick ending point
	        for (int j=i; j<n; j++)
	        {
	            // Print subarray between current starting
	            // and ending points
	            for (int k=i; k<=j; k++)
	                System.out.print(arr[k]+ " ");
	 
	            System.out.println();
	        }
	    }
	}
	
	
	public static void printSubArrays(int[] array,int start,int end,Map<Integer,List<Integer>> map)
	{
		if(start >= end) return;
		
		if( map ==null || map.get(start) == null || !map.get(start).contains(end)){
			//System.out.println(" Start :"+start+ ":"+"End : "+end);
			 printArray(array,start,end);
			 
			 if(map.get(start)== null){
				 List<Integer> listmap  = new ArrayList<Integer>();
				 listmap.add(end);
			 map.put(start,listmap);
			 }
			 else{
				 List<Integer> listmap = map.get(start);
				 listmap.add(end);
				 map.put(start, listmap);
			 }
		}

	   printSubArrays(array, start, end-1,map);
	   printSubArrays(array, start+1, end,map);
	}
	
	
	public static void printArray(int[] arr,int start,int end){
		for(int i=start;i< end;i++) System.out.print(arr[i]+ " | ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4};
		
		printSubArrays(array, 0, 4,new TreeMap<Integer,List<Integer>>());
		
		//subArray(array, 4);
	}

}
