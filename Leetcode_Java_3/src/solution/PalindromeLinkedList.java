package solution;

import util.ListNode;

/*
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode mid = null;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			mid = slow;
			slow = slow.next;
			mid.next = null;
		}

		prev.next = null;

		ListNode halfStart = slow;
		halfStart = reverse2(halfStart);

		return compare(head, halfStart);
	}

	private ListNode reverse(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}

		ListNode next = node.next;

		node.next = null;
		ListNode res = reverse(next);
		next.next = node;

		return res;
	}

	private ListNode reverse2(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}

		ListNode p1 = node;
		ListNode p2 = node.next;
		p1.next = null;
		while (p1 != null && p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}

		return p1;
	}

	private boolean compare(ListNode node1, ListNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.val != node2.val) {
			return false;
		}

		return compare(node1.next, node2.next);
	}

	public static void main(String[] args) {
		PalindromeLinkedList test = new PalindromeLinkedList();
		ListNode n1 = new ListNode(0);
		n1.next = new ListNode(0);

		test.isPalindrome(n1);
	}
}
