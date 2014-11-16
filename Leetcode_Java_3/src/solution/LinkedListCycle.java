package solution;

import util.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode cur = head;
		ListNode tail = cur;

		while (tail != null && tail.next != null) {
			cur = cur.next;
			tail = tail.next.next;

			if (tail == cur) {
				return true;
			}
		}

		return false;
	}
}
