package solution;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return new TreeNode(head.val);
		}

		ListNode tail = head;
		ListNode cur = head;
		ListNode prev = cur;
		while (tail != null && tail.next != null) {
			tail = tail.next.next;
			prev = cur;
			cur = cur.next;
		}
		ListNode tmp = cur.next;
		prev.next = null;

		TreeNode root = new TreeNode(cur.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(tmp);

		return root;
	}
}
