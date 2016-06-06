package solution;

import util.TreeNode;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		TreeNode[] nodes = new TreeNode[3];

		if (root == null) {
			return;
		}

		inOrder(root, nodes);
		swap(nodes[0], nodes[1]);
	}

	private void swap(TreeNode node1, TreeNode node2) {
		int tmp = node1.val;

		node1.val = node2.val;
		node2.val = tmp;
	}

	private void inOrder(TreeNode root, TreeNode[] nodes) {
		if (root == null) {
			return;
		}

		inOrder(root.left, nodes);
		if (nodes[2] == null) {
			nodes[2] = root;
		} else {
			if (nodes[2].val > root.val) {
				if (nodes[0] == null) {
					nodes[0] = nodes[2];
				}
				nodes[1] = root;
			}
			nodes[2] = root;
		}
		inOrder(root.right, nodes);
	}
}
