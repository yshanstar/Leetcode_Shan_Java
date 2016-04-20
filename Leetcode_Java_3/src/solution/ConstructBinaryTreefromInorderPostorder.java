package solution;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromInorderPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0 || postorder == null
				|| postorder.length == 0) {
			return null;
		}

		Map<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			nodeMap.put(inorder[i], i);
		}

		return helper(postorder, 0, postorder.length - 1, inorder, 0,
				inorder.length - 1, nodeMap);
	}

	private TreeNode helper(int[] postOrder, int postStart, int postEnd,
			int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> nodeMap) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postOrder[postEnd]);

		int rootIdx = nodeMap.get(root.val);

		int left = rootIdx - inStart;

		root.left = helper(postOrder, postStart, postStart + left - 1, inOrder,
				inStart, rootIdx - 1, nodeMap);

		root.right = helper(postOrder, postStart + left, postEnd - 1, inOrder,
				rootIdx + 1, inEnd, nodeMap);

		return root;
	}
}
