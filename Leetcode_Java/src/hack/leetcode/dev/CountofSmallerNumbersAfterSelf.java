package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

Show Company Tags
Show Tags

 */
public class CountofSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> sorted = new ArrayList<Integer>();
		int length = nums.length;

		List<Integer> result = new LinkedList<Integer>();
		for (int i = length - 1; i >= 0; i--) {
			int num = helper(sorted, nums[i]);
			result.add(0, num);
		}

		return result;
	}

	private int helper(List<Integer> sorted, int val) {
		int left = 0;
		int size = sorted.size();

		if (size == 0) {
			sorted.add(val);
			return 0;
		} else if (val > sorted.get(size - 1)) {
			sorted.add(size, val);
			return size;
		}

		int right = size - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (sorted.get(mid) >= val) {
				right = mid;
			} else {
				left = mid;
			}
		}

		int tmp = sorted.get(left) >= val ? left : right;
		sorted.add(tmp, val);
		return tmp;
	}

	public List<Integer> countSmaller2(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		BSTNode root = new BSTNode(nums[nums.length - 1]);

		root.num = 1;
		list.add(0);

		for (int i = nums.length - 2; i >= 0; i--) {
			list.add(get(root, nums[i], 0));
		}

		Collections.reverse(list);

		return list;
	}

	public int get(BSTNode root, int val, int num) {
		if (root.val >= val) {
			root.num = root.num + 1;
			if (root.left == null) {
				BSTNode node = new BSTNode(val);
				node.num = 1;
				root.left = node;
				return num;
			} else {
				return get(root.left, val, num);
			}
		} else {
			num += root.num;
			if (root.right == null) {
				BSTNode node = new BSTNode(val);
				node.num = 1;
				root.right = node;
				return num;
			} else {
				return get(root.right, val, num);
			}
		}
	}

	public static void main(String[] args) {
		CountofSmallerNumbersAfterSelf test = new CountofSmallerNumbersAfterSelf();
		int[] nums = new int[] { 5, 2, 6, 1 };

		test.countSmaller(nums);
	}
}

class BSTNode {
	int val;
	int num;
	BSTNode left;
	BSTNode right;

	public BSTNode(int val) {
		this.left = this.right = null;
		this.num = 0;
		this.val = val;
	}
}
