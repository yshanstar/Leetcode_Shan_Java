package solution;

import util.ListNode;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = head.next;
		ListNode newHead = null;

		while (cur != null && next != null) {
			ListNode tmp = next.next;
			next.next = cur;
			cur.next = tmp;
			if (prev != null) {
				prev.next = next;
			}
			if (newHead == null) {
				newHead = next;
			}
			prev = cur;
			cur = cur.next;
			next = (cur != null) ? cur.next : null;
		}

		return newHead;
	}
}