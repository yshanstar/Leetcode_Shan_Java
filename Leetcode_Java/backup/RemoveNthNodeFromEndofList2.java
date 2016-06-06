package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndofList2 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n <= 0) {
			return head;
		}
		ListNode preNth = head;
		ListNode nthNode = head;
		ListNode tail = head;

		while (n > 1) {
			tail = tail.next;
			n--;
		}
		while (tail.next != null) {
			tail = tail.next;
			preNth = nthNode;
			nthNode = nthNode.next;
		}

		if (nthNode == head) {
			return (nthNode.next != null) ? nthNode.next : null;
		} else if (nthNode.next != null) {
			preNth.next = nthNode.next;
		} else {
			preNth.next = null;
		}

		return head;
	}
}
