package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode cur = null;
		ListNode head = null;
		if (l1 == null && l2 == null) {
			return head;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val <= l2.val) {
			cur = l1;
			l1 = l1.next;
		} else {
			cur = l2;
			l2 = l2.next;
		}
		head = cur;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
			} else {
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			cur.next = l1;
			cur = cur.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			cur.next = l2;
			cur = cur.next;
			l2 = l2.next;
		}
		return head;
	}
}
