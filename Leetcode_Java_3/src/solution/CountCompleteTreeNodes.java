package solution;

import util.TreeNode;

/*
 * Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, 
is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int lh = findTreeH(root.left);
		int rh = findTreeH(root.right);

		if (lh == rh) {
			return (1 << lh) + countNodes(root.right);
		} else {
			return (1 << rh) + countNodes(root.left);
		}
	}

	private int findTreeH(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + findTreeH(root.left);
	}
}
