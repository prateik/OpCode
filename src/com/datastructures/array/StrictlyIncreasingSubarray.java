package com.datastructures.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*Count Strictly Increasing Subarrays
Given an array of integers, count number of subarrays (of size more than one) that are strictly increasing.
Expected Time Complexity : O(n)
Expected Extra Space: O(1)

Examples:

Input: arr[] = {1, 4, 3}
Output: 1
There is only one subarray {1, 4}

Input: arr[] = {1, 2, 3, 4}
Output: 6
There are 6 subarrays {1, 2}, {1, 2, 3}, {1, 2, 3, 4}
                      {2, 3}, {2, 3, 4} and {3, 4}

Input: arr[] = {1, 2, 2, 4}
Output: 2
There are 2 subarrays {1, 2} and {2, 4}*/

public class StrictlyIncreasingSubarray {

	static int count = 0;

	public static int factorial(int num) {
		if (num == 0)
			return 1;
		else
			return factorial(num - 1) * (num);
	}

	public static int nCr(int n, int r) {
		return factorial(n) / (factorial(n - r) * factorial(r));
	}

	public static int getCount(int number) {
		if (number == 0)
			return 0;
		return (number - 1) + getCount(number - 1);
	}

	public static List<int[]> getIncreasingSubArrays(int[] array)

	{

		int increasingCount = 1;
		int startIndex = 0;
		List<int[]> increasingArrayList = new ArrayList<int[]>();
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i + 1]) {
				// System.out.println("comparing "+array[i]+" : "+array[i+1]);
				increasingCount++;
			}

			if (i == array.length - 2 || array[i] >= array[i + 1]) {

				if (increasingCount > 1) {

					// System.out.println("Found SubArray of Size :
					// "+increasingCount);
					// System.out.println("Start Index : "+startIndex);
					int[] increasingArray = new int[increasingCount];
					for (int j = startIndex; j < startIndex + increasingCount; j++) {
						increasingArray[j - startIndex] = array[j];
					}

					increasingArrayList.add(increasingArray);

					count += getCount(increasingArray.length);

					startIndex += increasingCount;
					increasingCount = 1;

				}

				else {
					startIndex++;
				}

			}
		}

		return increasingArrayList;

	}

	public static void printList(List<int[]> array) {
		System.out.println(" Increasing Subarrays : ");

		for (int[] arr : array) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " | ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 2, 4};

		List<int[]> arr = getIncreasingSubArrays(array);

		printList(arr);

		System.out.println(count);
	}
}

