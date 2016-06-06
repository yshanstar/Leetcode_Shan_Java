package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *	If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *	You may not alter the values in the nodes, only nodes itself may be changed.
 *	Only constant memory is allowed.
 *	For example,
 *	Given this linked list: 1->2->3->4->5
 *	For k = 2, you should return: 2->1->4->3->5
 *	For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseFirstKthNodes {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (k == 0 || head.next == null) {
			return head;
		}

		ListNode cur = head.next;
		ListNode pre = head;
		int count = 1;
		while (count < k) {
			ListNode tmpHead = head;
			ListNode after = cur.next;
			cur.next = tmpHead;

			pre.next = after;
			head = cur;
			cur = pre.next;
			count++;

		}
		return head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		// ListNode n3 = new ListNode(3);
		// ListNode n4 = new ListNode(4);
		// ListNode n5 = new ListNode(5);

		n1.next = n2;
		// n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;

		reverseKGroup(n1, 2);
	}
}
