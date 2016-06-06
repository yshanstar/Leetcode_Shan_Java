package solution;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
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
