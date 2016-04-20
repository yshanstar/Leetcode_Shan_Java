package solution;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null
				|| inorder.length == 0) {
			return null;
		}

		Map<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			nodeMap.put(inorder[i], i);
		}

		return helper(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1, nodeMap);
	}

	private TreeNode helper(int[] preOrder,  int preStart,
			int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> nodeMap) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preOrder[preStart]);

		int rootIdx = nodeMap.get(root.val);
		int left = rootIdx - inStart;

		root.left = helper(preOrder, preStart + 1, preEnd + left,inOrder, 
				inStart, rootIdx - 1, nodeMap);
		root.right = helper(preOrder, preStart + left + 1, preEnd
				+ left, inOrder, rootIdx + 1, inEnd, nodeMap);

		return root;
	}
}
