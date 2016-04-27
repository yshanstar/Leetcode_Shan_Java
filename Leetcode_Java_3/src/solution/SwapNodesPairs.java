package solution;

import util.ListNode;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode next = cur.next;
		if (next == null) {
			return cur;
		}

		ListNode tmp = next.next;
		cur.next = null;
		next.next = cur;

		cur.next = swapPairs(tmp);

		return next;
	}

	public ListNode swapPairsII(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = null;
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = cur.next;

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
			cur = tmp;
			next = (cur != null) ? cur.next : null;
		}

		return newHead;
	}
}
