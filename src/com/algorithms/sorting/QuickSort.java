package com.algorithms.sorting;

public class QuickSort {

	
	public static void quickSort(int[] arr,int left,int right)
	{
		
		int index  = partition(arr,left,right);
		
		if(left < index -1) quickSort(arr, left, index-1);
		if(index < right) quickSort(arr, index, right);
		
	}
	
	public static int partition(int[] arr,int left,int right){
		
		
		int pivot = arr[right];
		System.out.println(" Pivot picked : "+pivot+ " left :"+left+ " right : "+right);
		printArray("Before swapping",arr);
		while(left <= right)
		{
			
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			
			
			if(left <= right){
				
				int temp = arr[left];
				arr[left] =arr[right];
				arr[right]=temp;
				
				left++;
				right--;
			}
		}

		return left;
	}
	
	public static void printArray(String message,int[] arr)
	{
		System.out.print(message+" : ");
		for(int i=0;i< arr.length;i++) System.out.print(arr[i]+",");
		System.out.println();
		
	}
	public static void main(String[] args) {

		
		int[] arr = new int[] {2,7,5,3};		
		
		for(int i=0;i< arr.length;i++) System.out.print(arr[i]+",");
		System.out.println();
		quickSort(arr, 0, arr.length-1);
		for(int i=0;i< arr.length;i++) System.out.print(arr[i]+",");
		
		
	}

}
