package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;
import hack.leetcode.ulti.TreeNode;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return (new TreeNode(head.val));
		} else {

			ListNode slow = head;
			ListNode fast = head;
			ListNode prev = slow;

			while (fast != null && fast.next != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}

			TreeNode root = new TreeNode(slow.val);
			root.right = sortedListToBST(slow.next);
			prev.next = null;
			root.left = sortedListToBST(head);

			return root;
		}
	}
}
