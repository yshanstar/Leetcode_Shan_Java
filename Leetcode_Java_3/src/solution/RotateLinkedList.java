package solution;

import util.ListNode;

/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateLinkedList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		int i = 1;
		ListNode fast = head;

		while (fast.next != null) {
			fast = fast.next;
			i++;
		}

		fast.next = head;
		int shift = k % i;
		int step = i - shift;

		while (step > 0) {
			fast = fast.next;
			step--;
		}

		ListNode newHead = fast.next;
		fast.next = null;
		return newHead;
	}
}
