package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TwoSumInBST {
	class NodePair {
		TreeNode n1;
		TreeNode n2;
		int sum;

		public NodePair(TreeNode n1, TreeNode n2) {
			this.n1 = n1;
			this.n2 = n2;
			this.sum = n1.val + n2.val;
		}

		public String toString() {
			return "(" + n1.val + "," + n2.val + ")";
		}
	}

	public List<NodePair> twoSumInBST(TreeNode root, int target) {
		List<NodePair> res = new ArrayList<NodePair>();

		if (root == null) {
			return res;
		}

		BSTIterator leftIter = new BSTIterator(root, true);
		BSTIterator rightIter = new BSTIterator(root, false);

		TreeNode low = leftIter.next();
		TreeNode high = rightIter.next();

		while (low != null && high != null && low != high && low.val < high.val) {
			int sum = low.val + high.val;

			if (sum == target) {
				res.add(new NodePair(low, high));
				low = leftIter.next();
				high = rightIter.next();
			} else if (sum < target) {
				low = leftIter.next();
			} else {
				high = rightIter.next();
			}
		}

		return res;
	}

	public static String printPairNode(List<NodePair> nodePairList) {
		StringBuilder sb = new StringBuilder();

		if (nodePairList.isEmpty()) {
			sb.append("[]");
			return sb.toString();
		}

		sb.append("[\n");
		for (NodePair pair : nodePairList) {
			sb.append(pair.toString() + "\n");
		}
		sb.append("]\n");
		return sb.toString();
	}

	public static String goThroughBSTIterator(BSTIterator iter) {
		StringBuilder sb = new StringBuilder();

		while (iter.hasNext()) {
			sb.append(iter.next().val + ",");
		}

		return sb.append("\n").toString();
	}

	public static void main(String[] args) {
		TwoSumInBST t = new TwoSumInBST();

		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(10);
		TreeNode n6 = new TreeNode(1);

		n1.left = n2;
		n1.right = n3;

		n3.left = n4;
		n3.right = n5;

		n2.left = n6;

		System.out.print(printPairNode(t.twoSumInBST(n1, 12)));
		System.out.print(printPairNode(t.twoSumInBST(n1, 16)));
		System.out.print(printPairNode(t.twoSumInBST(n1, 6)));

		BSTIterator leftToRight = new BSTIterator(n1, true);
		BSTIterator rightToLeft = new BSTIterator(n1, false);

		System.out.print(goThroughBSTIterator(leftToRight));
		System.out.print(goThroughBSTIterator(rightToLeft));
	}
}

class BSTIterator implements Iterator<TreeNode> {
	Stack<TreeNode> stack;
	boolean isLeftToRight;

	public BSTIterator(TreeNode node, boolean isLeftToRight) {
		this.isLeftToRight = isLeftToRight;

		stack = new Stack<TreeNode>();

		TreeNode cur = node;
		if (isLeftToRight) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		} else {
			while (cur != null) {
				stack.push(cur);
				cur = cur.right;
			}
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode next() {
		if (hasNext()) {
			TreeNode node = stack.pop();

			// if it is left to right iterator
			if (isLeftToRight) {
				if (node.right != null) {
					TreeNode tmp = node.right;
					while (tmp != null) {
						stack.push(tmp);
						tmp = tmp.left;
					}
				}
			}
			// if it is right to left iterator
			else {
				if (node.left != null) {
					TreeNode tmp = node.left;
					while (tmp != null) {
						stack.push(tmp);
						tmp = tmp.right;
					}
				}
			}

			return node;
		} else {
			return null;
		}
	}
}
