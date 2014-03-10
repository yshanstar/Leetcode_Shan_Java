package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;
import hack.leetcode.ulti.TreeNode;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree2 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return (new TreeNode(head.val));
		} else {
			ListNode mid = head;
			ListNode tail = head;
			ListNode prev = mid;

			while (tail != null && tail.next != null) {
				prev = mid;
				mid = mid.next;
				tail = tail.next.next;
			}

			TreeNode root = new TreeNode(mid.val);
			root.right = sortedListToBST(mid.next);
			prev.next = null;
			root.left = sortedListToBST(head);
			return root;
		}
	}
}
