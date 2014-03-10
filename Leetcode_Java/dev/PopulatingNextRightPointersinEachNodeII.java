package hack.leetcode.dev;

import hack.leetcode.ulti.TreeLinkNode;

/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
 * After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode runner = root;
		while (runner != null) {
			runner = myConnect(runner);
		}
	}

	private TreeLinkNode myConnect(TreeLinkNode root) {
		if (root == null) {
			return null;
		}

		TreeLinkNode leftmost;
		if (root.left != null) {
			leftmost = root.left;
			if (root.right != null) {
				root.left.next = root.right;
				root.right.next = myConnect(root.next);
			} else {
				root.left.next = myConnect(root.next);
			}
		} else {
			if (root.right != null) {
				leftmost = root.right;
				root.right.next = myConnect(root.next);
			} else {
				return myConnect(root.next);
			}
		}

		return leftmost;
	}
}
