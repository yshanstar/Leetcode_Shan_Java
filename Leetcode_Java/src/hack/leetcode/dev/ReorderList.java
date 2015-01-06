package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode mid = head;
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
			if (cur.next != null) {
				cur = cur.next;
			} else {
				break;
			}
			mid = mid.next;
		}

		ListNode head1 = head;
		ListNode head2 = mid.next;

		mid.next = null;

		cur = head2;
		ListNode post = cur.next;
		cur.next = null;
		while (post != null) {
			ListNode tmp = post.next;
			post.next = cur;
			cur = post;
			post = tmp;
		}

		head2 = cur;

		while (head2 != null) {
			ListNode tmp1 = head1.next;
			ListNode tmp2 = head2.next;
			head1.next = head2;
			head2.next = tmp1;
			head1 = tmp1;
			head2 = tmp2;
		}
	}
}
