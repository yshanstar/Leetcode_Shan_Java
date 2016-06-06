package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}

		Stack<TreeNode> currentLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		ArrayList<Integer> levelNode = new ArrayList<Integer>();

		boolean order = true;

		currentLevel.push(root);

		while (!currentLevel.isEmpty()) {
			TreeNode node = currentLevel.pop();
			levelNode.add(node.val);
			if (order) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}
				if (node.right != null) {
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextLevel.push(node.right);
				}
				if (node.left != null) {
					nextLevel.push(node.left);
				}
			}

			if (currentLevel.isEmpty()) {
				order = order ? false : true;
				res.add(levelNode);
				levelNode = new ArrayList<Integer>();
				currentLevel = nextLevel;
				nextLevel = new Stack<TreeNode>();
			}
		}

		return res;
	}
}
