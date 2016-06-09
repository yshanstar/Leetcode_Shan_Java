package solution;

import util.SegmentTreeNode;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 Subscribe to see which companies asked this question
 */
public class RangeSumQueryMutable {
	SegmentTreeNode root = null;

	public RangeSumQueryMutable(int[] nums) {
		if (nums == null || nums.length == 0) {
			root = null;
		} else {
			root = buildSegmentTree(nums, 0, nums.length - 1);
		}
	}

	void update(int i, int val) {
		update(root, i, val);
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	private void update(SegmentTreeNode node, int i, int val) {
		if (node == null) {
			return;
		}

		if (node.start == node.end) {
			node.sum = val;
		} else {
			int mid = (node.end + node.start) / 2;
			if (i <= mid) {
				update(node.left, i, val);
			} else {
				update(node.right, i, val);
			}

			node.sum = ((node.left != null) ? node.left.sum : 0) + ((node.right != null) ? node.right.sum : 0);
		}
	}

	private int sumRange(SegmentTreeNode node, int start, int end) {
		if (start > end) {
			return 0;
		}

		if (node.start == start && node.end == end) {
			return node.sum;
		} else {
			int mid = (node.start + node.end) / 2;

			if (end <= mid) {
				return sumRange(node.left, start, end);
			} else if (start > mid) {
				return sumRange(node.right, start, end);
			} else {
				return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
			}
		}
	}

	private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start == end) {
			root.sum = nums[start];
		} else {
			int mid = (end + start) / 2;

			root.left = buildSegmentTree(nums, start, mid);
			root.right = buildSegmentTree(nums, mid + 1, end);

			if (root.left != null) {
				root.sum += root.left.sum;
			}

			if (root.right != null) {
				root.sum += root.right.sum;
			}
		}

		return root;
	}
}
