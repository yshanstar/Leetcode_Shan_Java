package solution;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		helper(root, sum, res, new ArrayList<Integer>());
		return res;
	}

	private void helper(TreeNode node, int sum, List<List<Integer>> res, List<Integer> tmp) {
		if (node == null) {
			return;
		}
		List<Integer> tmpRes = new ArrayList<Integer>(tmp);
		if (node.left == null && node.right == null) {
			if (node.val == sum) {
				tmpRes.add(node.val);
				res.add(tmpRes);
				return;
			} else {
				return;
			}
		}
		tmpRes.add(node.val);
		helper(node.left, sum - node.val, res, tmpRes);
		helper(node.right, sum - node.val, res, tmpRes);
	}

	public static void main(String[] args) {
		PathSumII test = new PathSumII();
		TreeNode root = new TreeNode(1);
		System.out.println(test.pathSum(root, 1));
	}
}
