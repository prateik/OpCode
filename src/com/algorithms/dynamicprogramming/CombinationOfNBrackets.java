package com.algorithms.dynamicprogramming;

import java.util.ArrayList;

public class CombinationOfNBrackets {

	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
		if (leftRem < 0 || rightRem < leftRem)
			return; // invalid state

		if (leftRem == 0
				&& rightRem == 0) { /* all out of left and right parentheses */
			String s = String.copyValueOf(str);
			System.out.println("Adding " + s);
			list.add(s);
		} else {
			if (leftRem > 0) { // try a left paren, if there are some available
				str[count] = '(';
				System.out.println("Added left (");
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			if (rightRem > leftRem) { // try a right paren, if there’s a
										// matching left
				str[count] = ')';
				System.out.println("Added right )");
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}

	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}

	public static void printCombinations(ArrayList<String> list, char[] brackets, int left, int right, int count)

	{

		if (right < left || left < 0)
			return;

		if (left == 0 && right == 0) {
			System.out.println(brackets);
			list.add(String.copyValueOf(brackets));
		}

		else {

			if (left > 0) {
				brackets[count] = '(';
				System.out.println("Added left (");
				printCombinations(list, brackets, left - 1, right, count + 1);
			}

			if (right > left) {
				brackets[count] = ')';
				System.out.println("Added right )");
				printCombinations(list, brackets, left, right - 1, count + 1);
			}
		}

	}

	public static void main(String[] args) {
		printCombinations(new ArrayList<String>(), new char[6], 3, 3, 0);

		/*
		 * ArrayList<String> list = generateParens(2); for (String s : list) {
		 * System.out.println(s); } System.out.println(list.size()); }
		 */

	}
}
