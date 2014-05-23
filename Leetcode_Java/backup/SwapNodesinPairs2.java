package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesinPairs2 {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;

		while (cur != null && cur.next != null) {
			next = cur.next;
			ListNode tmp = next.next;
			next.next = cur;
			cur.next = tmp;

			if (pre != null) {
				pre.next = next;
			}

			if (cur == head) {
				head = next;
			}
			pre = cur;
			cur = cur.next;
		}

		return head;
	}
}
