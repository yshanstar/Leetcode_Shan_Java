package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode p = helper;

		while (p.next != null) {
			if (p.next.val == val) {
				ListNode next = p.next;
				p.next = next.next;
			} else {
				p = p.next;
			}
		}

		return helper.next;
	}

	public static void main(String[] args) {
		RemoveLinkedListElements test = new RemoveLinkedListElements();
		ListNode head = new ListNode(1);

		test.removeElements(head, 1);

	}
}
