package solution;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

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
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.offer(root);

		while (!nodeQueue.isEmpty()) {
			int size = nodeQueue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = nodeQueue.poll();
				if (i == size - 1) {
					res.add(tmp.val);
				}

				if (tmp.left != null) {
					nodeQueue.offer(tmp.left);
				}

				if (tmp.right != null) {
					nodeQueue.offer(tmp.right);
				}
			}
		}

		return res;
	}
}
