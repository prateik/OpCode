package com.mathematics;

import java.util.HashMap;

public class RecursiveSeqInFraction {

	public static void findRecurrenceSeq(int numerator, int denominator) {

		// System.out.println(" Value :
		// "+((float)numerator/(float)denominator));

		if (numerator % denominator == 0) {
			System.out.println("No recurrence sequence");
		}

		else {

			boolean patternFound = false;
			double remainder = ((double) numerator % (double) denominator);
			remainder /= (double) denominator;

			// System.out.println("Remainder : "+remainder);
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			while (!patternFound) {
				Integer digit = (int) (remainder * 10);

				if (map.containsKey(digit) && map.get(digit) > 0) {
					patternFound = true;
				} else {
					// System.out.println("Adding : "+digit);
					map.put(digit, 1);
				}

				remainder = (remainder * 10) - digit;

			}

			System.out.print(" Recurrence Sequence : ");
			for (Integer e : map.keySet())
				System.out.print(e);

		}
	}

	public static void main(String[] args) {

		findRecurrenceSeq(22,3);
	}

}
