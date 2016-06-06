package solution;

import util.RandomListNode;

/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
* Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode tmp = new RandomListNode(cur.label);
			tmp.next = cur.next;
			cur.next = tmp;
			cur = tmp.next;
		}

		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		cur = head.next;
		RandomListNode newHead = cur;
		RandomListNode oldHead = head;

		while (oldHead != null) {
			oldHead.next = cur.next;
			if (oldHead.next != null) {
				cur.next = oldHead.next.next;
			}
			oldHead = oldHead.next;
			cur = cur.next;
		}

		return newHead;
	}

	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null) {
			return head;
		}
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode newNode = new RandomListNode(cur.label);
			newNode.next = cur.next;
			cur.next = newNode;
			cur = newNode.next;
		}

		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		cur = head.next;
		RandomListNode newHead = cur;
		RandomListNode oldHead = head;

		while (oldHead != null) {
			oldHead.next = cur.next;
			if (oldHead.next != null) {
				cur.next = oldHead.next.next;
			}
			cur = cur.next;
			oldHead = oldHead.next;
		}
		return newHead;
	}
}
