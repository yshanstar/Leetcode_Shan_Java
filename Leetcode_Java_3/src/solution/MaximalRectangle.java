package solution;

import java.util.Stack;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * 
 * https://leetcode.com/discuss/52670/solution-based-maximum-rectangle-histogram-with-explanation
 * https://leetcode.com/discuss/104498/java-5ms-100%25-solution-by-modifying-bu-will-9s-solution
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int[] height = new int[matrix[0].length];
		int m = matrix.length;
		int n = matrix[0].length;

		for (int j = 0; j < n; j++) {
			height[j] = (matrix[0][j] == '1') ? 1 : 0;
		}

		int result = largestInLine(height);

		for (int i = 1; i < m; i++) {
			resetHeight(matrix, height, i);
			result = Math.max(result, largestInLine(height));
		}

		return result;
	}

	private void resetHeight(char[][] matrix, int[] height, int row) {
		for (int j = 0; j < matrix[row].length; j++) {
			if (matrix[row][j] == '0') {
				height[j] = 0;
			} else {
				height[j]++;
			}
		}
	}

	private int largestInLine(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int len = height.length;

		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;

		for (int i = 0; i <= len; i++) {
			int h = (i == len) ? 0 : height[i];

			if (stack.isEmpty() || h >= height[stack.peek()]) {
				stack.push(i);
			} else {
				int tp = stack.pop();
				maxArea = Math.max(maxArea, height[tp] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
				i--;
			}
		}

		return maxArea;
	}

	public int maximalRectangle2(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = row == 0 ? 0 : matrix[0].length;

		int[][] nums = new int[row][col + 1];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '0') {
					nums[i][j] = 0;
				} else {
					nums[i][j] = i == 0 ? 1 : nums[i - 1][j] + 1;
				}
			}
		}

		int maxRetangle = 0;
		for (int i = 0; i < row; i++) {
			int area = largestRectangle(nums[i]);
			maxRetangle = Math.max(maxRetangle, area);
		}
		return maxRetangle;
	}

	public int largestRectangle(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		while (i < nums.length) {
			if (stack.isEmpty() || nums[stack.peek()] <= nums[i]) {
				stack.push(i++);
			} else {
				int idx = stack.pop();
				max = Math.max(max, nums[idx] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
		char[][] matrix = new char[][] { { '1' } };
		System.out.println(test.maximalRectangle(matrix));
	}
}
