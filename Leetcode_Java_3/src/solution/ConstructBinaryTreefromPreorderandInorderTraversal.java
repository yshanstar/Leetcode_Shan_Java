package solution;

import java.util.HashMap;

import Util.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0
				|| inorder.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inOrderMap.put(inorder[i], i);
		}
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1, inOrderMap);
	}

	private TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
			int[] inOrder, int inStart, int inEnd,
			HashMap<Integer, Integer> inOrderMap) {
		TreeNode root = new TreeNode(preOrder[preStart]);
		int rootIdx = inOrderMap.get(root.val);
		if (preStart == preEnd && preOrder[preStart] == inOrder[inStart]) {
			return root;
		}
		if (rootIdx > inStart) {
			root.left = buildTree(preOrder, preStart + 1, preStart + rootIdx
					- inStart, inOrder, inStart, rootIdx - 1, inOrderMap);
		}
		if (rootIdx < inEnd) {
			root.right = buildTree(preOrder, preStart + rootIdx - inStart + 1,
					preEnd, inOrder, rootIdx + 1, inEnd, inOrderMap);
		}
		return root;
	}
}
