package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList2 {
	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode tail = head;
		int length = 1;
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}
		tail.next = head;

		int shift = n % length;
		int step = length - shift;
		while (step > 0) {
			tail = tail.next;
			step--;
		}

		ListNode newHead = tail.next;
		tail.next = null;

		return newHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		System.out.println(rotateRight(n1, 1).val);
	}
}
