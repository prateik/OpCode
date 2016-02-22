package com.algortihms.dynamicprogramming;


/* Given an array of weights and their  values(benefits)
 * Pick all weights such that the benefit is maximum with the
 *  constraint that sum of weights should not exceed capacity.
 */
public class Knapsack {

	public static int getMaxBenefit(int[] weights, int[] benefits, int capacity) {

		int[][] maxbenefit = new int[weights.length + 1][capacity + 1];

		for (int i = 0; i <= weights.length; i++)
			maxbenefit[i][0] = 0;
		for (int i = 0; i <= capacity; i++)
			maxbenefit[0][i] = 0;

		for (int item = 1; item <= weights.length; item++) {

			for (int weight = 1; weight <= capacity; weight++) {

				if (weights[item - 1] <= weight) {

					int option1 = benefits[item - 1] + maxbenefit[item - 1][weight - weights[item - 1]];
					int option2 = maxbenefit[item - 1][weight];
					maxbenefit[item][weight] = Math.max(option1, option2);

				} else {
					maxbenefit[item][weight] = maxbenefit[item - 1][weight];
				}

			}

			// printMatrix(maxbenefit, weights.length, capacity);
		}

		printMatrix(maxbenefit, weights.length, capacity);

		return 0;
	}

	public static void printMatrix(int[][] matrix, int R, int C) {
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= C; j++) {

				System.out.print(matrix[i][j] + " | ");

			}

			System.out.println();
		}

	}

	public static void main(String[] args) {
		int[] weights = new int[] { 2, 3, 4, 5, 6 };
		int[] benefit = new int[] { 3, 4, 8, 9, 9 };
		getMaxBenefit(weights, benefit, 5);
	}

}
