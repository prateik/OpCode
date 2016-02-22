package com.datastructures.array;

public class FindNumberOccuringOddNoOFTimes {
	
	
	/*method 1: A Simple Solution is to run two nested loops. The outer loop picks all elements one by one and inner loop counts number of occurrences of the element picked by outer loop. Time complexity of this solution is O(n2).

	method 2: A Better Solution is to use Hashing. Use array elements as key and their counts as value. Create an empty hash table. One by one traverse the given array elements and store counts. Time complexity of this solution is O(n). But it requires extra space for hashing.

	method 3: The Best Solution is to do bitwise XOR of all the elements. XOR of all elements gives us odd occurring element. Please note that XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
	*/
	
	
	
	public static int getOddNumberTimes(int[] array)
	{
		int element =array[0];
		
		for(int i=1 ;i < array.length;i++)
		{
			element = element ^ array[i];
			
		}
		
		return element;
	}
	
	public static void main(String[] args) {

		 int[] array = new int[]{1,2,3,4,4,3,4};
		
		System.out.println(getOddNumberTimes(array));
	}

}
