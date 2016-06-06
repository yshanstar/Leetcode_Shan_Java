package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum2 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return preOrder(root, sum);
	}

	private boolean preOrder(TreeNode node, int sum) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null && sum == node.val) {
			return true;
		} else if (node.left == null && node.right == null && sum != node.val) {
			return false;
		}
		return preOrder(node.left, sum - node.val) || preOrder(node.right, sum - node.val);
	}

	public static void main(String[] args) {
		PathSum2 test = new PathSum2();
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		root.left = n1;
		System.out.println(test.hasPathSum(root, 2));
	}
}
