package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int h1 = 0;
		int h2 = 0;

		TreeNode left = root.left;
		TreeNode right = root.right;

		while (left != null) {
			h1++;
			left = left.left;
		}

		while (right != null) {
			h2++;
			right = right.right;
		}

		if (h1 == h2) {
			return (2 << h2) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}
}
