package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given

         1
        / \
       2   5
      / \   \
     3   4   6
 * The flattened tree should look like:
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
public class FlattenBinaryTreetoLinkedList2 {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		inOrder(root, nodes);

		if (nodes.size() == 1) {
			return;
		}

		for (int i = 1; i < nodes.size(); i++) {
			nodes.get(i - 1).right = nodes.get(i);
			nodes.get(i - 1).left = null;
		}
		nodes.get(nodes.size() - 1).left = null;
		nodes.get(nodes.size() - 1).right = null;
	}

	private void inOrder(TreeNode node, ArrayList<TreeNode> nodes) {
		if (node == null) {
			return;
		}
		nodes.add(node);
		inOrder(node.left, nodes);
		inOrder(node.right, nodes);
	}
}
