package com.algortihms.dynamicprogramming;

public class MagicIndexInArray {

	public static int findMagicIndex(int[] arr, int low, int high) {

		if (low > high)
			return -1;

		System.out.println(" Search Range : "+low +"-"+high);
		int mid = (low + high) / 2;

		if (arr[mid] == mid)
			return arr[mid];

		if (arr[mid] < mid) {
			return findMagicIndex(arr, mid + 1, high);
		}

		else {
			return findMagicIndex(arr, low, mid - 1);
		}

	}

	public static void main(String[] args) {

		int[] array = new int[] { 1, 1, 4, 9, 12, 15 };
        System.out.println(MagicIndexInArray.findMagicIndex(array, 0, array.length));
	}

}
