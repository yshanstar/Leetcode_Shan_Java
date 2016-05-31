package solution;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 https://leetcode.com/discuss/63606/very-concise-java-solution-no-stack-with-explanations
 */
public class TrappingRainWater {
	public static int trap(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int secHigh = 0;
		int left = 0;
		int right = height.length - 1;
		int res = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secHigh = Math.max(secHigh, height[left]);
				res += secHigh - height[left];
				left++;
			} else {
				secHigh = Math.max(secHigh, height[right]);
				res += secHigh - height[right];
				right--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] water = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		trap(water);
	}

	public int trap2(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int left[] = new int[A.length];
		int right[] = new int[A.length];

		int max = 0;
		for (int i = 0; i < A.length; i++) {
			left[i] = max;
			max = Math.max(max, A[i]);
		}

		max = A[A.length - 1];
		right[A.length - 1] = max;
		for (int i = A.length - 2; i >= 0; i--) {
			right[i] = max;
			max = Math.max(max, A[i]);
		}

		int cTrap = 0;
		for (int i = 0; i < A.length; i++) {
			int tmp = Math.min(left[i], right[i]) - A[i];
			cTrap += (tmp > 0) ? tmp : 0;
		}

		return cTrap;
	}
}
