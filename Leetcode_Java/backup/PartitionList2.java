package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList2 {
	public ListNode partition(ListNode head, int x) {
		ListNode beforeStart = null;
		ListNode afterEnd = null;
		ListNode afterStart = null;
		ListNode beforeEnd = null;

		if (head == null) {
			return head;
		}
		while (head != null) {
			ListNode next = head.next;
			head.next = null;
			if (head.val < x) {
				if (beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = head;
					beforeEnd = beforeEnd.next;
				}
			} else {
				if (afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				} else {
					afterEnd.next = head;
					afterEnd = afterEnd.next;
				}
			}
			head = next;
		}
		if (beforeStart == null) {
			return afterStart;
		}
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
