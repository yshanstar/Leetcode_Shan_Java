package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

public class BinaryTreeInorderTraversal2 {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		inOrder(root, res);
		return res;
	}

	private void inOrder(TreeNode node, ArrayList<Integer> res) {
		if (node == null) {
			return;
		}
		inOrder(node.left, res);
		res.add(node.val);
		inOrder(node.right, res);
	}
}
