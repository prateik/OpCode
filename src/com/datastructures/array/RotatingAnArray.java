package com.datastructures.array;

public class RotatingAnArray {
	
	
	/*METHOD 1 (Use temp array)

	Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
	1) Store d elements in a temp array
	   temp[] = [1, 2]
	2) Shift rest of the arr[]
	   arr[] = [3, 4, 5, 6, 7, 6, 7]
	3) Store back the d elements
	   arr[] = [3, 4, 5, 6, 7, 1, 2]
	Time complexity O(n)
	Auxiliary Space: O(d)
	
	METHOD 2 (Rotate one by one)

	leftRotate(arr[], d, n)
	start
	  For i = 0 to i < d
	    Left rotate all elements of arr[] by one
	end
	
	Time complexity: O(n*d)
	Auxiliary Space: O(1)
	
	METHOD 3 (A Juggling Algorithm)
	This is an extension of method 2. Instead of moving one by one, divide the array in different sets
	where number of sets is equal to GCD of n and d and move the elements within sets.
	If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only, we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.

	Here is an example for n =12 and d = 3. GCD is 3 and
	
			Time complexity: O(n)
			Auxiliary Space: O(1)
	*/
	

	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
