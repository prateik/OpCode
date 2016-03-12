package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ReturnAllSubsets {

	public static List<ArrayList<Integer>> getAllSubsets(int[] array, int index, List<ArrayList<Integer>> allSubsets) {

		// System.out.println("Adding All Subsets for index :" + index);

		if (index == 0) {
			ArrayList<Integer> subset = new ArrayList<Integer>();
			subset.add(array[index]);

			allSubsets.add(subset);

		}

		else {

			ArrayList<Integer> newSubset = new ArrayList<Integer>();

			newSubset.add(array[index]);
			List<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> list : allSubsets) {
				ArrayList<Integer> newList = new ArrayList<Integer>();

				newList.addAll(list);
				newList.add(array[index]);
				moresubsets.add(newList);
			}
			allSubsets.addAll(moresubsets);
			allSubsets.add(newSubset);

		}

		if (index < array.length - 1) {
			allSubsets = getAllSubsets(array, index + 1, allSubsets);
		}
		return allSubsets;
	}

	public static void printSet(ArrayList<Integer> subsetsAdded) {

		for (Integer i : subsetsAdded)
			System.out.print(i + " , ");
		System.out.println();
	}

	public static void printAllSubsets(List<ArrayList<Integer>> subsets)

	{

		for (List<Integer> subset : subsets) {
			for (Integer i : subset) {
				System.out.print(i + " , ");
			}
			System.out.println();
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = new int[] { 0, 1, 2, 3 };

		List<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		subsets = getAllSubsets(array, 0, subsets);
		printAllSubsets(subsets);
	}

}
