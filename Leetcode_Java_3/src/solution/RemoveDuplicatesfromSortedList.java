package solution;

import util.ListNode;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode tmp = head;

		while (tmp != null && tmp.next != null) {
			if (tmp.val == tmp.next.val) {
				tmp.next = tmp.next.next;
			} else {
				tmp = tmp.next;
			}
		}

		return head;
	}

	public ListNode deleteDuplicates3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = null;

		ListNode cur = head;
		ListNode prev = null;

		while (cur != null) {
			if (prev == null) {
				prev = cur;
			} else {
				if (newHead == null) {
					newHead = prev;
				}
				if (cur.val != prev.val) {
					prev.next = cur;
					prev = cur;
				} else {
					prev.next = null;
				}
			}
			cur = cur.next;
		}

		return newHead;
	}

	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = null;
		ListNode cur = head;
		ListNode prev = null;
		while (cur != null) {
			if (prev == null) {
				prev = cur;
			} else {
				if (newHead == null) {
					newHead = prev;
				}
				if (prev.val != cur.val) {
					prev.next = cur;
					prev = cur;
				} else {
					prev.next = null;
				}
			}
			cur = cur.next;
		}
		return newHead;
	}
}
