package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		if (m >= n) {
			return head;
		}

		ListNode nodeM = head;
		ListNode nodeN = head;
		ListNode preM = null;
		ListNode afterN = nodeN.next;

		int count = 1;
		while (count < n) {
			nodeN = afterN;
			afterN = (afterN.next != null) ? afterN.next : null;
			if (count < m) {
				preM = nodeM;
				nodeM = nodeM.next;
			} else {
				nodeN.next = nodeM;
				nodeM = nodeN;
			}
			count++;
			if (count == m) {
				nodeM.next = null;
			}
		}
		if (afterN == null && preM == null) {
			head.next = null;
			return nodeN;
		} else if (afterN == null) {
			preM.next = nodeN;
			return head;
		}
		if (preM == null) {
			head.next = afterN;
			return nodeN;
		}
		preM.next.next = afterN;
		preM.next = nodeN;

		return head;
	}
}
