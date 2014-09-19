package solution;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
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
				max = Math.max(max, nums[idx]
						* (stack.isEmpty() ? i : (i - stack.peek() - 1)));
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
