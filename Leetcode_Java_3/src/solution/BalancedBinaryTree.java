package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.TreeNode;

/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

	public boolean isBalanced2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		int leftDepth = height2(root.left);
		int rightDepth = height2(root.right);

		if (Math.abs(rightDepth - leftDepth) > 1) {
			return false;
		}

		return isBalanced2(root.left) && isBalanced2(root.right);

	}

	private int height2(TreeNode node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		return Math.max(height2(node.left), height2(node.right)) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		int leftDepth = height(root.left);
		int rightDepth = height(root.right);

		if (Math.abs(leftDepth - rightDepth) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);

	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public static void pagnation(String[] data, int pageSize) {
		if (data == null || data.length <= 1) {
			return;
		}

		List<String> dataList = new ArrayList<String>();
		for (int i = 1; i < data.length; i++) {
			dataList.add(data[i]);
		}

		Set<String> keys = new HashSet<String>();

		while (!dataList.isEmpty()) {
			List<String> copy = new ArrayList<String>(dataList);
			for (int i = 0; i < pageSize && i < dataList.size(); i++) {
				String[] record = dataList.get(i).split(",");
				String hostId = record[0];
				if (!keys.contains(hostId)) {
					keys.add(hostId);
					System.out.println(dataList.get(i));
					copy.remove(dataList.get(i));
				}
			}
			dataList = copy;
			keys.clear();
		}

	}

	public static void main(String[] args) {
		String[] data = new String[] { "host_id,listing_id,score,city", "1,28,300.1,San Francisco",
				"4,5,209.1,San Francisco", "20,7,208.1,San Francisco", "23,8,207.1,San Francisco",
				"16,10,206.1,Oakland", "1,16,205.1,San Francisco", "1,31,204.6,San Francisco",
				"6,29,204.1,San Francisco", "7,20,203.1,San Francisco", "8,21,202.1,San Francisco",
				"2,18,201.1,San Francisco", "2,30,200.1,San Francisco", "15,27,109.1,Oakland", "10,13,108.1,Oakland",
				"11,26,107.1,Oakland", "12,9,106.1,Oakland", "13,1,105.1,Oakland", "22,17,104.1,Oakland",
				"1,2,103.1,Oakland", "28,24,102.1,Oakland", "18,14,11.1,San Jose", "6,25,10.1,Oakland",
				"19,15,9.1,San Jose", "3,19,8.1,San Jose", "3,11,7.1,Oakland", "27,12,6.1,Oakland", "1,3,5.1,Oakland",
				"25,4,4.1,San Jose", "5,6,3.1,San Jose", "29,22,2.1,San Jose", "30,23,1.1,San Jose" };

		pagnation(data, 12);
	}

}
