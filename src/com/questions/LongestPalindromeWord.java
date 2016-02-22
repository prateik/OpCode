package com.questions;

public class LongestPalindromeWord {

	protected static String getLongestPalindrome(String sentence) {

		if (sentence == null || sentence.trim().equals(' '))
			return null;

		int longestPalindromeLength = 0;
		String longestPalindrome = null;

		String[] words = sentence.split(" ");

		for (String word : words) {

			if (word.length() > longestPalindromeLength)

			{

				if (isPalindrome(word)) {
					longestPalindromeLength = word.length();
					longestPalindrome = word;

				}

			}

		}
		return longestPalindrome;

	}

	protected static boolean isPalindrome(String word) {

		if (word == null || word.trim().equals(" "))
			return false;

		for (int i = 0; i < word.length() / 2; i++) {

			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {

				return false;

			}

		}

		return true;

	}

	public static void main(String[] args) {

		
		System.out.println(getLongestPalindrome("hello aaaaaaaaaa abcdcba abcdedcba"));
	}
}
