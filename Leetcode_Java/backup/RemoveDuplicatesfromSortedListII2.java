package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}

		ListNode prev = new ListNode(-1);
		prev.next = head;
		head = prev;

		ListNode n = head;

		while (n.next != null) {
			ListNode next = n.next;
			while (next.next != null && next.next.val == next.val) {
				next = next.next;
			}

			if (next != n.next) {
				n.next = next.next;
			} else {
				n = n.next;
			}
		}

		return head.next;
	}

}
