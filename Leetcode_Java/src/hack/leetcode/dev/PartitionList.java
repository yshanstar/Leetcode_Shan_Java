package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 	Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *	You should preserve the original relative order of the nodes in each of the two partitions.
 *	For example,
 *	Given 1->4->3->2->5->2 and x = 3,
 *	return 1->2->2->4->3->5.
 */
public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}

		Queue<ListNode> lessNodes = new LinkedList<ListNode>();
		Queue<ListNode> aboveNodes = new LinkedList<ListNode>();

		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				lessNodes.add(cur);
			} else {
				aboveNodes.add(cur);
			}
			cur = cur.next;
		}
		cur = null;
		ListNode newHead = null;
		if (!lessNodes.isEmpty()) {
			newHead = lessNodes.poll();
			cur = newHead;
		}

		while (lessNodes.peek() != null) {
			ListNode tmp = lessNodes.poll();
			cur.next = tmp;
			cur = cur.next;
		}

		if (newHead == null) {
			newHead = aboveNodes.poll();
			cur = newHead;
		}

		while (aboveNodes.peek() != null) {
			ListNode tmp = aboveNodes.poll();
			cur.next = tmp;
			cur = cur.next;
		}

		if (cur != null && cur.next != null) {
			cur.next = null;
		}

		return newHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode newHead = partition(n1, 3);

		while (newHead != null) {
			System.out.print(newHead.val + ", ");
			newHead = newHead.next;
		}
	}
}
