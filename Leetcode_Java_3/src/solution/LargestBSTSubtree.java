package solution;

import util.TreeNode;

/*
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
 */
public class LargestBSTSubtree {
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return helper(root).count;
	}

	private TreeNodeExtra helper(TreeNode root) {
		if (root == null) {
			return new TreeNodeExtra(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
		}

		if (root.left == null && root.right == null) {
			return new TreeNodeExtra(root.val, root.val, true, 1);
		}

		TreeNodeExtra left = helper(root.left);
		TreeNodeExtra right = helper(root.right);

		if (left.isBST && right.isBST && (left.count == 0 || left.max < root.val)
				&& (right.count == 0 || right.min > root.val)) {
			return new TreeNodeExtra(Math.min(root.val, left.min), Math.max(root.val, right.max), true,
					left.count + right.count + 1);
		}

		return new TreeNodeExtra(Integer.MAX_VALUE, Integer.MIN_VALUE, false, Math.max(left.count, right.count));
	}

	class TreeNodeExtra {
		int min;
		int max;
		boolean isBST;
		int count;

		public TreeNodeExtra(int min, int max, boolean isBST, int count) {
			this.min = min;
			this.max = max;
			this.isBST = isBST;
			this.count = count;
		}
	}
}
