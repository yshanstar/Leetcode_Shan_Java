package hack.leetcode.dev;

import java.util.Arrays;
import java.util.Stack;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle2 {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length <= 0) {
			return 0;
		}

		int[][] matrixNum = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			matrixNum[0][i] = (matrix[0][i] == '1') ? 1 : 0;
		}

		for (int i = 1; i < matrixNum.length; i++) {
			for (int j = 0; j < matrixNum[i].length; j++) {
				matrixNum[i][j] = (matrix[i][j] == '1') ? matrixNum[i - 1][j] + 1 : 0;
			}
		}

		int maxArea = 0;
		for (int i = 0; i < matrixNum.length; i++) {
			maxArea = Math.max(maxArea, maximalRetangle(matrixNum[i]));
		}
		return maxArea;
	}

	private int maximalRetangle(int[] height) {
		Stack<Integer> posStack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		int[] heights = new int[height.length + 1];
		heights = Arrays.copyOf(height, height.length + 1);

		while (i < heights.length) {
			if (posStack.empty() || heights[posStack.peek()] <= heights[i]) {
				posStack.push(i++);
			} else {
				int t = posStack.pop();
				max = Math.max(max, heights[t] * (posStack.empty() ? i : i - 1 - posStack.peek()));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '0', '0', '1', '0' }, { '1', '1', '1', '1' }, { '1', '1', '1', '1' }, { '1', '1', '1', '0' }, { '1', '1', '0', '0' },
				{ '1', '1', '1', '1' }, { '1', '1', '1', '0' } };
		MaximalRectangle2 test = new MaximalRectangle2();
		System.out.println(test.maximalRectangle(matrix));
	}
}
