package hack.leetcode.dev;

import java.util.ArrayList;

import hack.leetcode.ulti.TreeNode;

/*
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *	For example:
 *	Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

 *	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		return preOrder(root, nodeList, sum);
	}
	
	private boolean preOrder(TreeNode node, ArrayList<TreeNode> nodeList, int sum){
		if (node == null) {
			return false;
		}
		ArrayList<TreeNode> curNodeList = new ArrayList<TreeNode>(nodeList);
		curNodeList.add(node);
		if (node.left == null && node.right == null) {
			int tmpSum = 0;
			for (TreeNode n : curNodeList) {
				tmpSum += n.val;
			}
			if (sum == tmpSum) {
				return true;
			} else {
				return false;
			}
		}
		return preOrder(node.left, curNodeList, sum) || preOrder(node.right, curNodeList, sum);
	}
}
