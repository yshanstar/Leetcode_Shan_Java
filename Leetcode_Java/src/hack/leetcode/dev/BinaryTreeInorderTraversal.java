package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

/*
 * 	Given a binary tree, return the inorder traversal of its nodes' values.
 *	For example:
 *	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
 *	Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		inOrder(root, res);
		return res;
	}

	private void inOrder(TreeNode node, ArrayList<Integer> res) {
		if (node == null) {
			return;
		}
		inOrder(node.left, res);
		res.add(node.val);
		inOrder(node.right, res);
	}
	
	public ArrayList<Integer> inorderTraversalIteratively(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);
		TreeNode node = root.left;
		while (!nodeStack.isEmpty() || node != null) {
			if (node != null) {
				nodeStack.push(node);
				node = node.left;
			} else {
				node = nodeStack.pop();
				res.add(node.val);
				node = node.right;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
		TreeNode node = new TreeNode(1);
		test.inorderTraversalIteratively(node);
		
	}
}
