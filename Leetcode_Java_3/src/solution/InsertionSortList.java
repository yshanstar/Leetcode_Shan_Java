package solution;

import util.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode runner = head.next;
		ListNode prev = head;

		while (runner != null) {
			if (prev.val <= runner.val) {
				prev = runner;
				runner = runner.next;
			} else {
				prev.next = runner.next;
				ListNode tmp = runner;
				runner = runner.next;

				ListNode search = head;
				ListNode pre = null;
				while (search.val < tmp.val) {
					pre = search;
					search = search.next;
				}

				if (pre == null) {
					tmp.next = head;
					head = tmp;
				} else {
					tmp.next = search;
					pre.next = tmp;
				}
			}
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(1);

		InsertionSortList test = new InsertionSortList();
		ListNode newHead = test.insertionSortList(head);
	}
}
