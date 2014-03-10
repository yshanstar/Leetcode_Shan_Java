package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateBST(1, n);
	}

	private ArrayList<TreeNode> generateBST(int start, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();

		if (start > end) {
			res.add(null);
		} else if (start == end) {
			res.add(new TreeNode(start));
		} else if (start < end) {
			for (int i = start; i <= end; i++) {
				ArrayList<TreeNode> lefts = generateBST(start, i - 1);
				ArrayList<TreeNode> rights = generateBST(i + 1, end);

				for (TreeNode left : lefts) {
					for (TreeNode right : rights) {
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
