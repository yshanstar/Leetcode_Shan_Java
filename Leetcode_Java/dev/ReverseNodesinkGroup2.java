package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinkGroup2 {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode pre = new ListNode(-1);
		pre.next = head;
		head = pre;

		ListNode cur = pre.next;

		while (cur != null) {
			int counter = k;
			while (cur != null && counter > 1) {
				cur = cur.next;
				counter--;
			}
			if (cur != null) {
				cur = pre.next;
				counter = k;
				while (counter > 1) {
					ListNode temp = cur.next;
					cur.next = temp.next;
					temp.next = pre.next;
					pre.next = temp;
					counter--;
				}
				pre = cur;
				cur = pre.next;
			}
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);

		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		reverseKGroup(head, 2);
	}
}
