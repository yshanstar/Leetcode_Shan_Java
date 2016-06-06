package solution;

import util.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		int i = 1;
		ListNode cur = head;
		ListNode tail = cur;
		while (tail.next != null) {
			tail = tail.next;
			i++;
		}
		tail.next = head;
		int shift = n % i;
		int step = i - shift;

		while (step > 0) {
			tail = tail.next;
			step--;
		}

		ListNode newHead = tail.next;
		tail.next = null;
		return newHead;
	}
}
