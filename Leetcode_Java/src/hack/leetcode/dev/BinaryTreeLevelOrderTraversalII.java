package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its bottom-up level order traversal as:
	[
	  [15,7]
	  [9,20],
	  [3],
	]
 */
public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> level = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return level;
		}
		Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
		ArrayList<Integer> curValue = new ArrayList<Integer>();
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		curLevel.add(root);

		while (!curLevel.isEmpty()) {
			TreeNode node = curLevel.poll();
			curValue.add(node.val);
			if (node.left != null) {
				nextLevel.add(node.left);
			}
			if (node.right != null) {
				nextLevel.add(node.right);
			}
			if (curLevel.isEmpty()) {
				level.add(curValue);
				curLevel = nextLevel;
				nextLevel = new LinkedList<TreeNode>();
				curValue = new ArrayList<Integer>();
			}
		}

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = level.size() - 1; i >= 0; i--) {
			res.add(level.get(i));
		}
		return res;
	}
}
