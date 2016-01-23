package solution;

import util.ListNode;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n) {
			return head;
		}

		ListNode preStart = null;
		ListNode start = head;
		ListNode end = head;
		ListNode afterEnd = head.next;

		int count = 1;
		while (count < n) {
			end = afterEnd;
			afterEnd = (afterEnd.next != null) ? afterEnd.next : null;

			if (count < m) {
				preStart = start;
				start = start.next;
			} else {
				end.next = start;
				start = end;
			}

			count++;

			if (count == m) {
				start.next = null;
			}
		}

		if (afterEnd == null && preStart == null) {
			head.next = null;
			return end;
		} else if (afterEnd == null) {
			preStart.next = end;
			return head;
		}

		if (preStart == null) {
			head.next = afterEnd;
			return end;
		}

		preStart.next.next = afterEnd;
		preStart.next = end;

		return head;
	}
}
