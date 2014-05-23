package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:

	    1
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
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * Here's an example:
	   1
	  / \
	 2   3
	    /
	   4
	    \
	     5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class SymmetricTree2 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root != null && root.left == null && root.right == null)) {
			return true;
		}
		return helper(root.left, root.right);
	}
	
	private boolean helper(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		}
		if (n1 == null || n2 == null) {
			return false;
		}
		if (n1.val != n2.val) {
			return false;
		}
		return helper(n1.right, n2.left) && helper(n1.left, n2.right);
	}
}
