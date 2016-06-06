package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 * 	Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *	For example,
 *	Given n = 3, your program should return all 5 unique BST's shown below.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTreeII {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	private ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
		} else if (start == end) {
			res.add(new TreeNode(start));
		} else if (start < end) {
			for (int i = start; i <= end; i++) {
				ArrayList<TreeNode> leftSubTrees = generateTrees(start, i - 1);
				ArrayList<TreeNode> rightSubTrees = generateTrees(i + 1, end);
				for (TreeNode left : leftSubTrees) {
					for (TreeNode right : rightSubTrees) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						res.add(root);
					}
				}
			}
		}
		return res;
	}
}
