package com.datastructures.string;

import java.util.HashMap;

public class CheckIfPermutation {

	public static boolean checkIfPermutation(String text, String perm) {

		if (text.length() != perm.length())
			return false;

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < text.length(); i++) {

			if (map.containsKey(String.valueOf(text.charAt(i))))
				map.put(String.valueOf(text.charAt(i)), map.get(text.charAt(i) + 1));
			else
				map.put(String.valueOf(text.charAt(i)), 1);

			if (map.containsKey(String.valueOf(perm.charAt(i))))
				map.put(String.valueOf(perm.charAt(i)), map.get(perm.charAt(i) - 1));
			else
				map.put(String.valueOf(perm.charAt(i)), -1);

		}

		for (Integer i : map.values()) {
			if (i != null && Integer.valueOf(i) > 0) {
				return false;
			}
		}
		return true;

	}

	public static void main(String args[]) {

		System.out.println(checkIfPermutation("aaadddd", "ddddaaa"));

	}

}
