package hack.leetcode.dev;

import java.util.ArrayList;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *      1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
 * But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null || (root != null && root.left == null && root.right == null)) {
			return true;
		}

		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		nodeList.add(root);

		while (!nodeList.isEmpty()) {
			int start = 0;
			int end = nodeList.size() - 1;
			while (start <= end) {
				if (nodeList.get(start) == null && nodeList.get(end) != null) {
					return false;
				} else if (nodeList.get(start) != null && nodeList.get(end) == null) {
					return false;
				} else if (nodeList.get(start) == null && nodeList.get(end) == null) {
					start++;
					end--;
				} else if (nodeList.get(start).val != nodeList.get(end).val) {
					return false;
				} else {
					start++;
					end--;
				}
			}
			ArrayList<TreeNode> tmpNodeList = new ArrayList<TreeNode>();
			while (!nodeList.isEmpty()) {
				if (nodeList.get(0) != null) {
					tmpNodeList.add(nodeList.get(0).left);
					tmpNodeList.add(nodeList.get(0).right);
				}
				nodeList.remove(0);
			}
			nodeList.addAll(tmpNodeList);
		}
		return true;
	}
	
	public boolean isSymmetricRecursively(TreeNode root) {
		if (root == null || (root != null && root.left == null && root.right == null)) {
			return true;
		}
		return isMirrorTree(root.left, root.right);
		
	}
	
	private boolean isMirrorTree(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		if (a.val != b.val) {
			return false;
		}
		return isMirrorTree(a.left, b.right) && isMirrorTree(a.right, b.left);
	}

}
