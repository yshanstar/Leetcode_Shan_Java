package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 * 	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *	An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *	Find the total sum of all root-to-leaf numbers.
 *	For example,
 1
 / \
 2   3
 *	The root-to-leaf path 1->2 represents the number 12.
 *	The root-to-leaf path 1->3 represents the number 13.
 *	Return the sum = 12 + 13 = 25. 
 */
public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		goThrough(root, 0, numbers);
		int sum = 0;
		for (Integer i : numbers) {
			sum += i;
		}
		return sum;
	}

	private void goThrough(TreeNode root, int v, ArrayList<Integer> numbers) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			numbers.add(v * 10 + root.val);
		}
		goThrough(root.left, v * 10 + root.val, numbers);
		goThrough(root.right, v * 10 + root.val, numbers);
	}
}