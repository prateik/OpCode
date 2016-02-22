package com.questions;

public class LargestContinuousSum {

	
	public static int getLargestContinuousSum(int[] arr)

	{
	          if(arr == null) return 0;

	    int max_sum = 0;
	    
	    int max_sum_prev = 0;
	    
	    
	    for(int i=0;i < arr.length;i++){
	    
	        max_sum += arr[i];

	          if(arr[i] < 0)
	           {
	           max_sum = 0;
	           }
	          if(max_sum >= max_sum_prev)
	        
	           {
	                max_sum_prev = max_sum;
	           }
    
	           }

	    return max_sum_prev;
	    
	   
	    }
	
	
	
	public static void main(String[] args) {

		
		
	}

}
