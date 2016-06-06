package solution;

import util.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}

		TreeNode root = helper(num, 0, num.length - 1);

		return root;
	}

	private TreeNode helper(int[] num, int start, int end) {
		if (start <= end) {
			int mid = (end + start) / 2;
			TreeNode root = new TreeNode(num[mid]);
			root.left = helper(num, start, mid - 1);
			root.right = helper(num, mid + 1, end);
			return root;
		}
		return null;
	}
}
