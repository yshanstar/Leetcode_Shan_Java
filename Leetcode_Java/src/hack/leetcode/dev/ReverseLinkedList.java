package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

public class ReverseLinkedList {
	public static ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = head.next;
		cur.next = null;

		ListNode reverseRest = reverseLinkedList(next);

		next.next = cur;

		return reverseRest;
	}

	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;

		ListNode cur = head;
		ListNode next = cur.next;
		cur.next = null;

		while (next != null) {
			ListNode tmp = next.next;
			next.next = cur;
			cur = next;
			newHead = next;
			next = tmp;
		}

		return newHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode n = reverseLinkedList(n1);

		ListNode head = n;
		
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}

		n = reverse(head);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}

	}
}
