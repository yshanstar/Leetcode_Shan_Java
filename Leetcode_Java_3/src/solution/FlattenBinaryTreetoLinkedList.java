package solution;

import Util.TreeNode;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		while (root != null) {
			if (root.left != null) {
				TreeNode tmp = root.left;
				while (tmp.right != null) {
					tmp = tmp.right;
				}
				tmp.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}

}
