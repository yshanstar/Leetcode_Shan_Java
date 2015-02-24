package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		while (!nodeStack.empty()) {
			TreeNode tmp = nodeStack.pop();
			res.add(tmp.val);

			if (tmp.right != null) {
				nodeStack.push(tmp.right);
			}

			if (tmp.left != null) {
				nodeStack.push(tmp.left);
			}
		}

		return res;

	}
}
