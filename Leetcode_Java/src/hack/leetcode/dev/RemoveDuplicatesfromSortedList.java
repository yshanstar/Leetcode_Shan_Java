package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.
 *	For example,
 *	Given 1->1->2, return 1->2.
 *	Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
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

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList n = new RemoveDuplicatesfromSortedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		n1.next = n2;

		n.deleteDuplicates(n1);
	}
}
