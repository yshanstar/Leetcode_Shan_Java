package solution;

import util.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return false;
		}

		return isMirrorTree(root.left, root.right);
	}

	private boolean isMirrorTree(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 == null || n2 == null) {
			return false;
		}

		if (n1.val != n2.val) {
			return false;
		}

		return isMirrorTree(n1.left, n2.right) && isMirrorTree(n1.right, n2.left);
	}
}
