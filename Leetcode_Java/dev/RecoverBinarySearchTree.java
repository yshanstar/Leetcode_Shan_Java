package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 *  Two elements of a binary search tree (BST) are swapped by mistake.
 *	Recover the tree without changing its structure.
 *	Note:
 *	A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		TreeNode[] nodeList = new TreeNode[3];

		if (root == null) {
			return;
		}
		inOrder(root, nodeList);
		swap(nodeList[0], nodeList[1]);
	}

	public void inOrder(TreeNode root, TreeNode[] nodeList) {
		if (root == null) {
			return;
		}
		inOrder(root.left, nodeList);
		if (nodeList[2] == null) {
			nodeList[2] = root;
		} else {
			if (nodeList[2].val > root.val) {
				if (nodeList[0] == null) {
					nodeList[0] = nodeList[2];
				}
				nodeList[1] = root;
			}
			nodeList[2] = root;
		}
		inOrder(root.right, nodeList);
	}

	private void swap(TreeNode a, TreeNode b) {
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}

	public static void main(String[] args) {
		RecoverBinarySearchTree test = new RecoverBinarySearchTree();
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		node1.right = node2;
		test.recoverTree(node1);
		System.out.println(node1.val + " : " + node2.val);
	}

}
