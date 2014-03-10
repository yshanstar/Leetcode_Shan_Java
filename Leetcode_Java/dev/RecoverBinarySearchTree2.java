package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree2 {
	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode[] nodes = new TreeNode[3];
		inOrder(root, nodes);
		swap(nodes[1], nodes[2]);
	}

	private void inOrder(TreeNode node, TreeNode[] nodes) {
		if (node == null) {
			return;
		}
		inOrder(node.left, nodes);
		if (nodes[0] == null) {
			nodes[0] = node;
		} else {
			if (node.val < nodes[0].val) {
				if (nodes[1] == null) {
					nodes[1] = nodes[0];
				}
				nodes[2] = node;
			}
			nodes[0] = node;
		}
		inOrder(node.right, nodes);

	}

	private void swap(TreeNode n1, TreeNode n2) {
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
	}
}
