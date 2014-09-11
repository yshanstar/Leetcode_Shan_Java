package solution;

import util.RandomListNode;

public class CopyListtwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
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
