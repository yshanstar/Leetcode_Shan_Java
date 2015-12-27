package solution;

import util.ListNode;

/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newHead = null;

		if (l1 == null && l2 == null) {
			return newHead;
		}

		if (l1 == null || l2 == null) {
			newHead = (l1 == null) ? l2 : l1;
			return newHead;
		}

		if (l1.val < l2.val) {
			newHead = l1;
			l1 = l1.next;
		} else {
			newHead = l2;
			l2 = l2.next;
		}

		ListNode cur = newHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
			}
		}

		while (l1 != null) {
			cur.next = l1;
			l1 = l1.next;
			cur = cur.next;
		}

		while (l2 != null) {
			cur.next = l2;
			l2 = l2.next;
			cur = cur.next;
		}

		return newHead;
	}
}
