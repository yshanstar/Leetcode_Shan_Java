package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.
 *	For example,
 *	Given 1->1->2, return 1->2.
 *	Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		ListNode nextAvail = cur;
		while (cur.next != null) {
			if (cur.val != cur.next.val) {
				nextAvail.next = cur.next;
				nextAvail = nextAvail.next;
			}
			cur = cur.next;
		}
		nextAvail.next = null;
		return head;
	}
}
