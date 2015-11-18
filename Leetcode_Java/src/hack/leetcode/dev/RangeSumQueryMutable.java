package hack.leetcode.dev;

import hack.leetcode.ulti.Ultitool;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {

	private SegmentTreeNode root;

	public RangeSumQueryMutable(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}

	void update(int i, int val) {
		update(root, i, val);
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	private int sumRange(SegmentTreeNode root, int start, int end) {
		if (root == null) {
			return 0;
		}

		if (root.start == start && root.end == end) {
			return root.sum;
		} else {
			int mid = (root.end + root.start) / 2;

			if (end <= mid) {
				return sumRange(root.left, start, end);
			} else if (start > mid) {
				return sumRange(root.right, start, end);
			} else {
				return sumRange(root.left, start, mid)
						+ sumRange(root.right, mid + 1, end);
			}
		}
	}

	private void update(SegmentTreeNode root, int i, int val) {
		if (root == null) {
			return;
		}

		if (root.start == root.end) {
			root.sum = val;
		} else {
			int mid = (root.end + root.start) / 2;
			if (i <= mid) {
				update(root.left, i, val);
			} else {
				update(root.right, i, val);
			}
			root.sum = ((root.left != null) ? root.left.sum : 0)
					+ ((root.right != null) ? root.right.sum : 0);
		}
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start == end) {
			root.sum = nums[start];
		} else {
			int mid = (end + start) / 2;
			root.left = buildTree(nums, start, mid);
			root.right = buildTree(nums, mid + 1, end);
			if (root.left != null) {
				root.sum += root.left.sum;
			}

			if (root.right != null) {
				root.sum += root.right.sum;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 9, 5, 7, 3 };
		RangeSumQueryMutable test = new RangeSumQueryMutable(nums);

		Ultitool.print(test.sumRange(4, 4));
		test.update(1, 2);
		Ultitool.print(test.sumRange(0, 2));
	}
}

class SegmentTreeNode {
	int sum;
	SegmentTreeNode left;
	SegmentTreeNode right;
	int start;
	int end;

	public SegmentTreeNode(int s, int e) {
		this.start = s;
		this.end = e;
		this.sum = 0;
		this.left = null;
		this.right = null;
	}
}
