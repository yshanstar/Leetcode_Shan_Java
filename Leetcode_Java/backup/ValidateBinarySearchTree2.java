package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree2 {
	public static boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValidBSTHelper(TreeNode node, int minValue, int maxValue) {
		if (node == null) {
			return true;
		}
		if (node.val > minValue && node.val < maxValue) {
			return isValidBSTHelper(node.left, minValue, node.val) && isValidBSTHelper(node.right, node.val, maxValue);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(6);
		root.left = n1;
		n1.right = n2;
		n2.right = n3;
		
		System.out.println(isValidBST(root));
	}
}
