package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.HashMap;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		int preLen = preorder.length;
		int inLen = inorder.length;
		if (preLen == 0 || inLen == 0) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTreeHelper(preorder, inorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildTreeHelper(int[] preOrder, int[] inOrder, HashMap<Integer, Integer> map, int preStart, int preEnd, int inStart, int inEnd) {
		TreeNode root = new TreeNode(preOrder[preStart]);
		root.left = null;
		root.right = null;
		int idx = map.get(root.val);
		if (preStart == preEnd && preOrder[preStart] == inOrder[inStart]) {
			return root;
		}
		if (idx - inStart > 0) {
			root.left = buildTreeHelper(preOrder, inOrder, map, preStart + 1, preStart + idx - inStart, inStart, idx - 1);
		}
		if (inEnd > idx) {
			root.right = buildTreeHelper(preOrder, inOrder, map, preStart + idx - inStart + 1, preEnd, idx + 1, inEnd);
		}
		return root;
	}
}
