package solution;

import util.TreeNode;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree2 {
	public void recoverTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		// node0 and node1 are the nodes need to swap;
		// node3 is the previous node in InOrder
		TreeNode[] nodes = new TreeNode[3];

		inorder(root, nodes);
		swap(nodes[0], nodes[1]);
	}

	private void inorder(TreeNode root, TreeNode[] nodes) {
		if (root == null) {
			return;
		}

		inorder(root.left, nodes);

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

		inorder(root.right, nodes);
	}

	private void swap(TreeNode n1, TreeNode n2) {
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
	}
}
