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
public class BinaryTreeZigzagLevelTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}

		int level = 0;
		Stack<TreeNode> cur = new Stack<TreeNode>();
		Stack<TreeNode> next = new Stack<TreeNode>();
		List<Integer> curLevel = new ArrayList<Integer>();
		cur.push(root);

		while (!cur.isEmpty()) {
			TreeNode n = cur.pop();

			if (level % 2 == 0) {
				// left to right
				if (n.left != null) {
					next.push(n.left);
				}
				if (n.right != null) {
					next.push(n.right);
				}
			} else {
				// left to right
				if (n.right != null) {
					next.push(n.right);
				}
				if (n.left != null) {
					next.push(n.left);
				}
			}

			curLevel.add(n.val);

			if (cur.isEmpty()) {
				cur = next;
				next = new Stack<TreeNode>();
				res.add(curLevel);
				curLevel = new ArrayList<Integer>();
				level++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryTreeZigzagLevelTraversal test = new BinaryTreeZigzagLevelTraversal();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		test.zigzagLevelOrder(root);
	}
}
