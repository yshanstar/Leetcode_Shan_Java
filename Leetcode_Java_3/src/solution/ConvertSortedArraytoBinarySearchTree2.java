package solution;

import util.TreeNode;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree2 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		TreeNode root = helper(nums, 0, nums.length - 1);

		return root;
	}

	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (end + start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);

		return root;
	}
}
