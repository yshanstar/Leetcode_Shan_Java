package solution;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> idxStack = new Stack<Integer>();
		int maxArea = 0;
		int i = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (idxStack.isEmpty() || h[idxStack.peek()] <= h[i]) {
				idxStack.push(i++);
			} else {
				int idx = idxStack.pop();
				maxArea = Math.max(maxArea, height[idx]
						* (idxStack.isEmpty() ? i : (i - idxStack.peek() - 1)));
			}
		}

		return maxArea;
	}
	
	public static void main(String[] args) {
		LargestRectangleinHistogram test = new LargestRectangleinHistogram();
		int[] matrix = new int[] { 1,2,3,2,1,2 };
		System.out.println(test.largestRectangleArea(matrix));
	}
}
