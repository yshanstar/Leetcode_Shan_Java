package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		Stack<TreeNode> first = new Stack<TreeNode>();
		Stack<TreeNode> second = new Stack<TreeNode>();

		first.push(root);

		while (!first.empty()) {
			TreeNode cur = first.pop();
			if (cur.left != null) {
				first.push(cur.left);
			}

			if (cur.right != null) {
				first.push(cur.right);
			}

			second.push(cur);
		}

		while (!second.empty()) {
			res.add(second.pop().val);
		}

		return res;
	}
}
