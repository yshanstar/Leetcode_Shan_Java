package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode cur = head.next;
		ListNode tmp = null;

		while (cur != null) {
			tmp = head;
			while (tmp.val < cur.val && tmp != cur) {
				tmp = tmp.next;
			}
			if (tmp != cur) {
				int first = cur.val;
				int second;
				while (tmp != cur) {
					second = tmp.val;
					tmp.val = first;
					first = second;
					tmp = tmp.next;
				}
				tmp.val = first;
			}
			cur = cur.next;
		}

		return head;
	}
}
