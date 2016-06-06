package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head;
		ListNode pre = head;
		ListNode tail = head;

		while (n > 1) {
			tail = tail.next;
			n--;
		}

		while (tail.next != null) {
			tail = tail.next;
			pre = cur;
			cur = cur.next;
		}

		if (cur == head) {
			return (cur.next != null) ? cur.next : null;
		} else if (cur.next != null) {
			ListNode nextNode = cur.next;
			pre.next = nextNode;
		} else {
			pre.next = null;
		}

		return head;
	}

	public static void main(String[] agrs) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);

		ListNode finalNode = removeNthFromEnd(node, 2);

		System.out.println(finalNode);
	}
}
