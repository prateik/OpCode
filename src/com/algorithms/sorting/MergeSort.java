package com.algorithms.sorting;

public class MergeSort {

	public static void mergeSort(int[] arr, int low, int high) {

		int mid = (high - low) / 2;
		if (arr.length < 1 || mid <= 0)
			return;

		System.out.println(" Mid = " + mid);
		int[] leftArr = new int[mid];
		int[] rightArr = new int[arr.length - leftArr.length];

		System.arraycopy(arr, 0, leftArr, 0, leftArr.length);
		System.arraycopy(arr, leftArr.length, rightArr, 0, rightArr.length);

		System.out.println(
				" Splitting into two arrays.." + getArrayasString(leftArr) + " and " + getArrayasString(rightArr));

		mergeSort(leftArr, low, mid);
		mergeSort(rightArr, mid , arr.length);

		System.out.println(" Merging.." + getArrayasString(leftArr) + " and " + getArrayasString(rightArr));

		merge(leftArr, rightArr, arr);
	}

	public static void merge(int[] arr1, int[] arr2, int[] arr) {
		System.out.println(" Start Merging... ");

		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] < arr2[j]) {
				// System.out.println(" Merging from left... "+arr1[i]);

				arr[k] = arr1[i];
				i++;

			} else {
				// System.out.println(" Merging from right... "+arr2[j]);
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}
		System.arraycopy(arr1, i, arr, k, arr1.length - i);
		System.arraycopy(arr2, j, arr, k, arr2.length - j);

		System.out.println(" After Merging " + getArrayasString(arr));

	}

	public static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " | ");
		}
		System.out.println();
	}

	public static String getArrayasString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " | ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int arr1[] = { 188, 12, 615, 426, 338 ,25,33};
		printArray(arr1);
		mergeSort(arr1, 0, arr1.length);
		printArray(arr1);

	}

}
