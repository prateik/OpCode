package com.algortihms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static ArrayList<Integer>[] getLongestIncreasingSubsequence(int[] array, ArrayList<Integer>[] list,
			int index) {

		list[index] = new ArrayList<Integer>();

		if (index == 0) {
			list[index].add(array[index]);

		}

		else {

			if (array[index] > array[index - 1]) {
				list[index].addAll(list[index - 1]);
				
			}

				list[index].add(array[index]);
		
		   }

		if (index == array.length - 1)
			return list;

		return getLongestIncreasingSubsequence(array, list, index + 1);

	}

	public static List<Integer> findLIS(int[] array) {

		ArrayList<Integer>[] arrayList = getLongestIncreasingSubsequence(array, new ArrayList[array.length], 0);

		int maxLength = arrayList[array.length - 1].size();
		int maxIndex = array.length - 1;
		for (int i = array.length - 2; i >= 0; i--) {
			if (arrayList[i].size() > maxLength) {
				maxLength = arrayList[i].size();
				maxIndex = i;
			}

		}

		return arrayList[maxIndex];

	}

	public static void main(String args[]) {

		int[] array = new int[] { 7, 1, -1, 8, 11,-4 };

		List<Integer> LIS = findLIS(array);

		for (Integer i : LIS)
			System.out.print(i + ",");

	}
}
