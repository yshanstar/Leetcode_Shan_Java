package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode halfStart;
		ListNode previous = head;
		ListNode mid;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			previous = slow;
			slow = slow.next;
		}

		if (fast != null) {
			mid = slow;
			slow = slow.next;
			mid.next = null;
		}

		previous.next = null;

		halfStart = slow;
		halfStart = reverse(halfStart);

		return compareList(head, halfStart);
	}

	private ListNode reverse(ListNode start) {
		ListNode prev = start;
		ListNode cur = start;
		ListNode next = start;

		if (cur.next == null) {
			return cur;
		}

		while (cur != null && cur.next != null) {
			next = cur.next;
			cur.next = next.next;
			next.next = prev;
			prev = next;
		}
		
		return prev;
	}

	private boolean compareList(ListNode head1, ListNode head2) {
		if (head1 == null && head2 == null) {
			return true;
		}

		if (head1 == null || head2 == null) {
			return false;
		}

		while (head1 != null && head2 != null) {
			if (head1.val != head2.val) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}

		return (head1 == null && head2 == null);
	}

	public static void main(String[] args) {
		PalindromeLinkedList test = new PalindromeLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		test.isPalindrome(node1);
	}
}
