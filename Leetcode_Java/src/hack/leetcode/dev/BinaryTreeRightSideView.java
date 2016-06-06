package hack.leetcode.dev;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
	For example:
	Given the following binary tree,
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	You should return [1, 3, 4].
 */


import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		List<TreeNode> current = new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();

		if (root == null) {
			return res;
		}

		if (root.left == null && root.right == null) {
			res.add(root.val);
			return res;
		}
		current.add(root);

		while (!current.isEmpty()) {
			TreeNode node = current.remove(0);

			if (node.left != null) {
				next.add(node.left);
			}

			if (node.right != null) {
				next.add(node.right);
			}


			if (current.isEmpty()) {
				res.add(node.val);
				current = next;
				next = new ArrayList<TreeNode>();
			}
		}

		return res;
	}
	
	public static void main(String[] args){
		BinaryTreeRightSideView test = new BinaryTreeRightSideView();
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		t3.left=t5;
		
		test.rightSideView(t1);
	}
}
