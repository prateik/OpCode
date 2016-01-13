package com.datastructures.string;

public class NoUniqueChars {

	public static boolean hasUniqueChars(String text) {

		if (text == null || text.equals("")) {
			return true;
		}

		boolean[] charFlags = new boolean[26];

		for (char c : text.toCharArray()) {
			if (charFlags[c - 'a'] == false) {
				charFlags[c - 'a'] = true;
			} else {
				return false;
			}
		}

		return true;

	}

	public static boolean hasUniqueChars2(String text) {

		if (text == null || text.equals("")) {
			return true;
		}

		int uniqueFlags = 0;
		for (int i = 0; i < text.length(); i++) {
			int index = text.charAt(i) - 'a';

			if ((uniqueFlags & (1 << index)) > 0) {
				return false;
			}

			else {
				uniqueFlags |= (1 << index);
			}

		}

		return true;
	}

	public static void main(String args[]) {

		System.out.println(" hasUniqueChars : " + NoUniqueChars.hasUniqueChars(null));
		System.out.println(" hasUniqueChars : " + NoUniqueChars.hasUniqueChars2("1123"));

	}

}
