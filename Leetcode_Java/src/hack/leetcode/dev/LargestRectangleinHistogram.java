package hack.leetcode.dev;

import java.util.Arrays;
import java.util.Stack;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram. 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10. 
 */
public class LargestRectangleinHistogram {
	public static int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);

		while (i < h.length) {
			if (stack.empty() || h[stack.peek()] < h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t]
						* (stack.empty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 1, 2, 2, 2, 2, 2 };
		System.out.println(largestRectangleArea(height));
	}
}
