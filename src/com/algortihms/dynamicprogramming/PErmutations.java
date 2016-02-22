package com.algortihms.dynamicprogramming;

import java.util.ArrayList;

public class PErmutations {

	public static ArrayList<String> getPermutations(String word)

	{
		//System.out.println("For word : " + word);
		if (word == null)
			return null;

		ArrayList<String> permutations = new ArrayList<String>();

		if (word.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char first = word.charAt(0);
		String restOfString = word.substring(1);
		ArrayList<String> words = getPermutations(restOfString);

		for (String wd : words) {

			System.out.println("FOR WORD : " + wd+ " first letter"+first);
			for (int j = 0; j <= wd.length(); j++) {

				System.out.println("Adding : " + wd.substring(0, j) + first + wd.substring(j));
				permutations.add(wd.substring(0, j) + first + wd.substring(j));
			}
		}

		return permutations;
	}

	public static void main(String[] args) {

		ArrayList<String> permuatation = getPermutations("abc");

		for (String word : permuatation)
			System.out.println(word);
	}

}
