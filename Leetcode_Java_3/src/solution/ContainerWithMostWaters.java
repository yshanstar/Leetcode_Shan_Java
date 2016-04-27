package solution;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class ContainerWithMostWaters {
	public int maxArea(int[] height) {
		if (height == null || height.length <= 1) {
			return 0;
		}
		int max = 0;
		int start = 0;
		int end = height.length - 1;

		while (start < end) {
			int v = Math.min(height[start], height[end]) * (end - start);
			max = Math.max(max, v);

			if (height[start] <= height[end]) {
				start++;
			} else {
				end--;
			}
		}

		return max;
	}
}
