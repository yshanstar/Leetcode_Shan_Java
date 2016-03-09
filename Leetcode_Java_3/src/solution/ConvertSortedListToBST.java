package solution;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return new TreeNode(head.val);
		} else {
			ListNode prev = null;
			ListNode slow = head;
			ListNode fast = head;

			while (fast != null && fast.next != null) {
				prev = slow;
				fast = fast.next.next;
				slow = slow.next;
			}

			ListNode next = slow.next;
			prev.next = null;
			TreeNode root = new TreeNode(slow.val);
			root.left = sortedListToBST(head);
			root.right = sortedListToBST(next);

			return root;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(3);

		ConvertSortedListToBST test = new ConvertSortedListToBST();
		test.sortedListToBST(n1);
	}
}
