package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			nodeMap.put(inorder[i], i);
		}

		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, nodeMap);
	}

	private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> nodeMap) {
		TreeNode root = new TreeNode(postorder[postEnd]);
		root.left = null;
		root.right = null;

		int idx = nodeMap.get(root.val);

		if (postStart == postEnd && inorder[inStart] == postorder[postStart]) {
			return root;
		}

		if (idx > inStart) {
			root.left = helper(inorder, inStart, idx - 1, postorder, postStart, postStart + idx - inStart - 1, nodeMap);
		}
		if (idx < inEnd) {
			root.right = helper(inorder, idx + 1, inEnd, postorder, postStart + (idx - inStart), postEnd - 1, nodeMap);
		}

		return root;
	}
}
