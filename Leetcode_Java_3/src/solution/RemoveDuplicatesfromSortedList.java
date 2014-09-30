package solution;

import util.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
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
