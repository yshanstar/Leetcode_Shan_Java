package solution;

import util.TreeLinkNode;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode rootNext = root.next;
		TreeLinkNode next = null;

		while (rootNext != null && next == null) {
			if (rootNext.left != null) {
				next = rootNext.left;
			} else {
				next = rootNext.right;
			}

			rootNext = rootNext.next;
		}

		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			} else {
				root.left.next = next;
			}
		}

		if (root.right != null) {
			root.right.next = next;
		}

		connect(root.right);
		connect(root.left);
	}
}
