package solution;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> path = new ArrayList<String>();
		if (root == null) {
			return path;
		}
		helper(root, "", path);

		return path;
	}

	private void helper(TreeNode node, String tmpPath, List<String> path) {
		if (node.left == null && node.right == null) {
			String tmpRes = tmpPath;
			tmpRes += (tmpRes.length() == 0) ? node.val : ("->" + node.val);
			path.add(tmpRes);
			return;
		}

		if (node.left != null) {
			helper(node.left, tmpPath + ((tmpPath.length() == 0) ? "" : "->") + String.valueOf(node.val), path);
		}

		if (node.right != null) {
			helper(node.right, tmpPath + ((tmpPath.length() == 0) ? "" : "->") + String.valueOf(node.val), path);
		}
	}

	public static void main(String[] args) {
		BinaryTreePaths test = new BinaryTreePaths();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		test.binaryTreePaths(root);
	}
}
