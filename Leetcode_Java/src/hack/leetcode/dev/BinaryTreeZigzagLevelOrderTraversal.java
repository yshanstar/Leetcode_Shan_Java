package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		ArrayList<TreeNode> curStack = new ArrayList<TreeNode>();
		curStack.add(root);
		boolean order = true;

		while (curStack.size() != 0) {
			ArrayList<TreeNode> nextStack = new ArrayList<TreeNode>();
			ArrayList<Integer> levelNode = new ArrayList<Integer>();
			for (TreeNode node : curStack) {
				levelNode.add(node.val);
			}
			res.add(levelNode);
			for (int i = curStack.size() - 1; i >= 0; i--) {
				TreeNode node = curStack.get(i);
				if (order) {
					if (node.right != null)
						nextStack.add(node.right);
					if (node.left != null)
						nextStack.add(node.left);
				} else {
					if (node.left != null)
						nextStack.add(node.left);
					if (node.right != null)
						nextStack.add(node.right);
				}
			}
			order = order ? false : true;
			curStack = new ArrayList<TreeNode>(nextStack);
		}

		return res;
	}
	
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n2.right = n4;
		
		test.zigzagLevelOrder(root);
		
	}
}
