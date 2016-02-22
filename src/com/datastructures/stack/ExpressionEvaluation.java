package com.datastructures.stack;

import java.util.Stack;

public class ExpressionEvaluation {

	public static boolean isNormalized(String expression) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {
			switch (expression.charAt(i)) {

			case '(':
				stack.push('(');
				break;

			case '{':
				stack.push('{');
				break;

			case '[':
				stack.push('[');
				break;

			case ')':
				if (stack.peek() == '(') {
					stack.pop();
				}
				else return false;
				break;

			case '}':
				if (stack.peek() == '{') {
					stack.pop();
				}
				else return false;
				break;

			case ']':
				if (stack.peek() == '[') {
					stack.pop();
				}
				else return false;
				break;

			}

		}

		return (stack.isEmpty());

	}

	public static void main(String[] args) {
		System.out.println(isNormalized("([]})"));

	}

}
