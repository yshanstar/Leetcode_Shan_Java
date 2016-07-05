package solution;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree 
 1
 / \
 2   3
 / \     
 4   5    
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

 1
 / 
 2          
 2. Now removing the leaf [2] would result in this tree:

 1          
 3. Now removing the leaf [1] would result in the empty tree:

 []         
 Returns [4, 5, 3], [2], [1].
 */
public class FindLeavesOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> leaves = new ArrayList<List<Integer>>();

		helper(root, leaves);

		return leaves;
	}

	private int helper(TreeNode node, List<List<Integer>> leaves) {
		if (null == node) {
			return -1;
		}

		int height = 1 + Math.max(helper(node.left, leaves), helper(node.right, leaves));

		if (leaves.size() < height + 1) {
			leaves.add(new ArrayList<Integer>());
		}

		leaves.get(height).add(node.val);

		return height;
	}
}
