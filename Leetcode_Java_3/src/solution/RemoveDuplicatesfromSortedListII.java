package solution;

import util.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = new ListNode(-1);
		prev.next = head;
		head = prev;

		ListNode cur = head;
		while (cur.next != null) {
			ListNode next = cur.next;
			while (next.next != null && next.next.val == next.val) {
				next = next.next;
			}
			if (next != cur.next) {
				cur.next = next.next;
			}else{
				cur = cur.next;
			}
		}

		return head.next;
	}
}
