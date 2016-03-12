package com.algorithms.dynamicprogramming;

import java.util.HashMap;

public class ExpressionEvaluation {

	
	public static int countDP(String exp, boolean result, int start, int end, HashMap<String, Integer> cache) {
		String key = "" + result + start + end;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		if (start == end) {
			if (exp.charAt(start) == '1' && result == true) {
				return 1;
			} else if (exp.charAt(start) == '0' && result == false) {
				return 1;
			}
			return 0;
		}
		int count = 0;
		if (result) {
			for (int i = start + 1; i <= end; i += 2) {
				char op = exp.charAt(i);
				if (op == '&') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache); 
				} else if (op == '|') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
				} else if (op == '^') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
				}
			}
		} else {
			for (int i = start + 1; i <= end; i += 2) {
				char op = exp.charAt(i);
				if (op == '&') {
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache); 
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
				} else if (op == '|') {
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
				} else if (op == '^') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
				}
			}			
		}
		cache.put(key, count);
		return count;
	}
	
	
	public static int countDPEff(String exp, boolean result, int start, int end, HashMap<String, Integer> cache) {
		String key = "" + start + end;
		int count = 0;
		if (!cache.containsKey(key)) {
			if (start == end) {
				if (exp.charAt(start) == '1') {
					count = 1;
				} else {
					count = 0;
				}
			}	
			
			for (int i = start + 1; i <= end; i += 2) {
				char op = exp.charAt(i);
				if (op == '&') {
					count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(exp, true, i + 1, end, cache); 
				} else if (op == '|') {
					int left_ops = (i - 1 - start) / 2; // parens on left
					int right_ops = (end - i - 1) / 2;  // parens on right
					int total_ways = total(left_ops) * total(right_ops);
					int total_false = countDPEff(exp, false, start, i - 1, cache) * countDPEff(exp, false, i + 1, end, cache);
					count += total_ways - total_false;
				} else if (op == '^') {
					count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(exp, false, i + 1, end, cache);
					count += countDPEff(exp, false, start, i - 1, cache) * countDPEff(exp, true, i + 1, end, cache);
				}
			}
			cache.put(key, count);
		} else {
			count = cache.get(key);
		}
		if (result) {
			return count;
		} else {
			int num_ops = (end - start) / 2;
			return total(num_ops) - count;
		}
	}	
	
	public static int total(int n) {
		// Function to return (2n) ! / ((n+1)! * n!)
		
		// To keep the numbers small, we divide by i when possible to do evenly. If not,
		// we store up the remainder and divide when possible.
		long num = 1;
		long rem = 1;
		for (int i = 2; i <= n; i++) {
			num *= (n + i);
			rem *= i;
			if (num % rem == 0) { 
				num /= rem;
				rem = 1;
			}
		}		
		return (int)num;
	}
	
	public static void main(String[] args) {
		String terms = "0^0|1&1^1|0|1";
		boolean result = true;
		System.out.println(countDPEff(terms, result, 0, terms.length() - 1, new HashMap<String, Integer>()));
		System.out.println(countDP(terms, false, 0, terms.length() - 1, new HashMap<String, Integer>()));
	}
}
