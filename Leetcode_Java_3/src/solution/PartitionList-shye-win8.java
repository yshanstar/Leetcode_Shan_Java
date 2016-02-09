package solution;

import java.util.LinkedList;
import java.util.Queue;

import util.ListNode;

/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		Queue<ListNode> lessQueue = new LinkedList<ListNode>();
		Queue<ListNode> largerQueue = new LinkedList<ListNode>();

		ListNode cur = head;

		while (cur != null) {
			if (cur.val < x) {
				lessQueue.offer(cur);
			} else {
				largerQueue.offer(cur);
			}

			cur = cur.next;
		}

		cur = null;
		ListNode newHead = null;
		if (!lessQueue.isEmpty()) {
			newHead = lessQueue.poll();
			cur = newHead;
		}

		while (lessQueue.peek() != null) {
			ListNode tmp = lessQueue.poll();
			cur.next = tmp;
			cur = cur.next;
		}

		if (newHead == null) {
			newHead = largerQueue.poll();
			cur = newHead;
		}

		while (largerQueue.peek() != null) {
			ListNode tmp = largerQueue.poll();
			cur.next = tmp;
			cur = cur.next;
		}

		if (cur != null && cur.next != null) {
			cur.next = null;
		}

		return newHead;
	}
}
