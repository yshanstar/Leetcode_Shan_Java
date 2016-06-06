package hack.leetcode.dev;

import java.util.ArrayList;

import hack.leetcode.ulti.TreeNode;

/*
 *  Given a binary tree, flatten it to a linked list in-place.
 *	For example,
 *	Given
         1
        / \
       2   5
      / \   \
     3   4   6

 *	The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 */
public class FlattenBinaryTreetoLinkedList {
	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		inOrder(root, res);

		if (res.size() == 1) {
			res.get(0).left = null;
			res.get(0).right = null;
			return;
		}

		for (int i = 0; i < res.size() - 1; i++) {
			res.get(i).left = null;
			res.get(i).right = res.get(i + 1);
		}
		res.get(res.size() - 1).left = null;
		res.get(res.size() - 1).right = null;
	}

	private static void inOrder(TreeNode node, ArrayList<TreeNode> res) {
		if (node == null) {
			return;
		}
		res.add(node);
		inOrder(node.left, res);
		inOrder(node.right, res);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		flatten(root);
	}
}
