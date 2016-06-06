package solution;

import util.ListNode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		boolean hasCycle = false;
		ListNode cur = head;
		ListNode tail = cur;

		while (tail != null && tail.next != null) {
			cur = cur.next;
			tail = tail.next.next;

			if (tail == cur) {
				hasCycle = true;
				break;
			}
		}

		if (!hasCycle) {
			return null;
		}

		cur = head;

		while (tail != cur) {
			cur = cur.next;
			tail = tail.next;
		}

		return tail;
	}
}
