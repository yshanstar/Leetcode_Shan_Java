package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		if (num.length == 1) {
			return new TreeNode(num[0]);
		}
		return sortedArraytoBST(num, 0, num.length - 1);
	}

	private TreeNode sortedArraytoBST(int[] num, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(num[mid]);
			root.left = sortedArraytoBST(num, start, mid - 1);
			root.right = sortedArraytoBST(num, mid + 1, end);
			return root;
		}
		return null;
	}
}
