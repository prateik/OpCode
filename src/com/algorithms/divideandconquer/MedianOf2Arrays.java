package com.algorithms.divideandconquer;

public class MedianOf2Arrays {

	
	
	public static int getMedian(int[] arr1,int[] arr2,int n){
	
		
		if(n ==0) return -1;
		
		if(n == 1) return (arr1[0]+arr2[0])/2;
		
		if(n == 2) return (Math.max(arr1[0], arr1[1]))+(Math.min(arr2[0], arr2[1])/2);
		
		
		int median1 = median(arr1,n);
		int median2 = median(arr2,n);
		
		if(median1 == median2) return median1;
		
		if(median1 < median2){
			
			if (n%2 == 0) return getMedian(arr1, arr2,n-n/2+1);
			return getMedian(arr1, arr2, n-n/2);
			
		}
		
		
		else{
			if (n%2 == 0) return getMedian(arr2, arr1,n-n/2+1);
			return getMedian(arr2, arr1, n-n/2);
			
		}
		
	}
	
	public static int median(int[] arr,int n)
	{
		
		if (n%2 == 0) return ((arr[n/2-1]+arr[n/2])/2);
		return arr[n/2];
		
	}
	
	
	
	
	
	public static void main(String args[]){
		
		 int arr1[] = {1, 12, 15, 26, 38};
		 int arr2[] = {2, 13, 17, 30, 45};
		System.out.println("Median : "+getMedian(arr1, arr2, 5));
		
	}
}
