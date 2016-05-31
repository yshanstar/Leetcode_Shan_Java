package solution;

import java.util.Map;
import java.util.TreeMap;

/*
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ¡Ü j), inclusive.

 Note:
 A naive algorithm of O(n2) is trivial. You MUST do better than that.

 Example:
 Given nums = [-2, 5, -1], lower = -2, upper = 2,
 Return 3.
 The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

 https://leetcode.com/discuss/79907/summary-divide-conquer-based-binary-indexed-based-solutions

 http://huntzhan.org/leetcode-count-of-range-sum/

 https://leetcode.com/discuss/79154/short-%26-simple-o-n-log-n

 https://leetcode.com/discuss/79083/share-my-solution

 https://leetcode.com/discuss/79903/java-bst-solution-averagely-o-nlogn
 */
public class CountOfRangeSum {
	private class TreeNode {
		long val;
		int count;
		int leftSize;
		int rightSize;
		TreeNode left;
		TreeNode right;

		public TreeNode(long v) {
			this.val = v;
			this.count = 1;
			this.leftSize = 0;
			this.rightSize = 0;
			this.left = null;
			this.right = null;
		}
	}

	private TreeNode insert(TreeNode root, long val) {
		if (root == null) {
			return new TreeNode(val);
		} else if (root.val == val) {
			root.count++;
		} else if (root.val > val) {
			root.leftSize++;
			root.left = insert(root.left, val);
		} else if (root.val < val) {
			root.rightSize++;
			root.right = insert(root.right, val);
		}

		return root;
	}

	private int countSmaller(TreeNode root, long val) {
		if (root == null) {
			return 0;
		} else if (root.val == val) {
			return root.leftSize;
		} else if (root.val > val) {
			return countSmaller(root.left, val);
		} else {
			return root.leftSize + root.count + countSmaller(root.right, val);
		}
	}

	private int countLarger(TreeNode root, long val) {
		if (root == null) {
			return 0;
		} else if (root.val == val) {
			return root.rightSize;
		} else if (root.val < val) {
			return countLarger(root.right, val);
		} else {
			return root.rightSize + root.count + countLarger(root.left, val);
		}
	}

	private int rangeSize(TreeNode root, long lower, long upper) {
		int total = root.count + root.leftSize + root.rightSize;

		int smaller = countSmaller(root, lower);
		int larger = countLarger(root, upper);

		return total - smaller - larger;
	}

	public int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		long[] sums = new long[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}

		TreeNode root = new TreeNode(sums[0]);
		int output = 0;
		for (int i = 1; i < sums.length; i++) {
			output += rangeSize(root, sums[i] - upper, sums[i] - lower);
			insert(root, sums[i]);
		}
		return output;
	}

	public int countRangeSum2(int[] nums, int lower, int upper) {
		Map<Long, Integer> map = new TreeMap<Long, Integer>();
		long[] sum = new long[nums.length + 1];
		map.put(0L, 1);
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
			map.put(sum[i + 1], map.containsKey(sum[i + 1]) ? map.get(sum[i + 1]) + 1 : 1);
		}

		for (int i = 0; i <= nums.length; i++) {
			map.put(sum[i], map.get(sum[i]) - 1);
			if (map.get(sum[i]) == 0) {
				map.remove(sum[i]);
			}

			for (Map.Entry<Long, Integer> entry : ((TreeMap<Long, Integer>) map).subMap(sum[i] + lower, sum[i] + upper + 1).entrySet())
				count += entry.getValue();
		}

		return count;
	}

	public static void main(String[] args) {
		int i = 3;
		int j = -3;

		System.out.println(i & j);
	}
}
