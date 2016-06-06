package solution;

import util.ListNode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1) {
			return head;
		}

		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = new ListNode(Integer.MIN_VALUE);
		prev.next = head;
		head = prev;

		ListNode cur = prev.next;

		while (cur != null) {
			int counter = k;

			while (cur != null && counter > 1) {
				cur = cur.next;
				counter--;
			}

			if (cur != null) {
				cur = prev.next;
				counter = k;

				while (counter > 1) {
					ListNode tmp = cur.next;
					cur.next = tmp.next;
					tmp.next = prev.next;
					prev.next = tmp;
					counter--;
				}

				prev = cur;
				cur = prev.next;
			}
		}

		return head.next;
	}
}
