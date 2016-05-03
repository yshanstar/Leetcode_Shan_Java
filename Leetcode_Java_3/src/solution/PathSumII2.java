package solution;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}

		helper(root, sum, new ArrayList<Integer>(), res);

		return res;
	}

	private void helper(TreeNode root, int sum, List<Integer> tmpRes, List<List<Integer>> res) {
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				tmpRes.add(root.val);
				res.add(new ArrayList<Integer>(tmpRes));
				return;
			}
		}

		if (root.left != null) {
			List<Integer> tmp = new ArrayList<Integer>(tmpRes);
			tmp.add(root.val);
			helper(root.left, sum - root.val, tmp, res);
		}

		if (root.right != null) {
			List<Integer> tmp = new ArrayList<Integer>(tmpRes);
			tmp.add(root.val);
			helper(root.right, sum - root.val, tmp, res);
		}
	}
}
