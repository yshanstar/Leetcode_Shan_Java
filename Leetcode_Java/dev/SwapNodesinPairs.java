package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 *  Given a linked list, swap every two adjacent nodes and return its head.
 *	For example,
 *	Given 1->2->3->4, you should return the list as 2->1->4->3.
 *	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;

		while (cur != null && cur.next != null) {
			next = cur.next;
			ListNode tmp = next.next;
			next.next = cur;
			cur.next = tmp;

			if (pre != null) {
				pre.next = next;
			}

			if (cur == head) {
				head = next;
			}
			pre = cur;
			cur = cur.next;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		ListNode p = new ListNode(2);
		ListNode q = new ListNode(3);
		ListNode r = new ListNode(4);
		
		n.next = p;
		p.next = q;
		q.next = r;
		
		swapPairs(n);
	}
}
