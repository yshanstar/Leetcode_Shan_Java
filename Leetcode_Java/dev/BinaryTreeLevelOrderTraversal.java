package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 */
public class BinaryTreeLevelOrderTraversal {
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> levelNode = new ArrayList<Integer>();
		ArrayList<TreeNode> curStack = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nextStack = new ArrayList<TreeNode>();
		curStack.add(root);

		while (curStack.size()!=0) {
			TreeNode node = curStack.remove(0);
			levelNode.add(node.val);
			if (node.left != null) {
				nextStack.add(node.left);
			}
			if (node.right != null) {
				nextStack.add(node.right);
			}
			if (curStack.size()==0) {
				res.add(levelNode);
				curStack = nextStack;
				nextStack = new ArrayList<TreeNode>();
				levelNode = new ArrayList<Integer>();
			}
		}

		return res;
	}
	
	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		System.out.println(levelOrder(root));
	}
}
