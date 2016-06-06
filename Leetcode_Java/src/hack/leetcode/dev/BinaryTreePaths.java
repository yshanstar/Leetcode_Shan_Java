package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
		List<String> res = new ArrayList<String>();
		if (root == null) {
			return res;
		}

		ArrayList<Integer> pathList = new ArrayList<Integer>();
		preOrder(root, res, pathList);

		return res;
	}

	private void preOrder(TreeNode node, List<String> res, List<Integer> path) {
		if(node == null){
			return;
		}
		ArrayList<Integer> curPath = new ArrayList<Integer>(path);
		curPath.add(node.val);
		if(node.left == null && node.right == null){
			StringBuilder sb = new StringBuilder();
			for(Integer i : curPath){
				sb.append("->").append(i);
			}
			sb.delete(0, 2);
			res.add(sb.toString());
			return;
		}
		preOrder(node.left,  res, curPath);
		preOrder(node.right, res, curPath);
	}
}
