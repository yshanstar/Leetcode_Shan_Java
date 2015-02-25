package solution;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return root.val;
		}

		List<Integer> res = new ArrayList<Integer>();

		helper(root, res, 0);

		int result = 0;
		for (Integer i : res) {
			result += i;
		}

		return result;
	}

	private void helper(TreeNode node, List<Integer> nums, int parent) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			nums.add(10 * parent + node.val);
			return;
		}

		if (node.left != null) {
			helper(node.left, nums, 10 * parent + node.val);
		}

		if (node.right != null) {
			helper(node.right, nums, 10 * parent + node.val);
		}
	}

	public static void main(String[] args) {
		SumRoottoLeafNumbers test = new SumRoottoLeafNumbers();

		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		root.left = left;

		System.out.println(test.sumNumbers(root));
	}
}
