package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return head;
		}

		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			len++;
		}

		if (len == 1) {
			return head;
		}

		int mid = len / 2 - 1;
		cur = head;
		int idx = 0;
		while (idx < mid) {
			cur = cur.next;
			idx++;
		}

		ListNode firstHead = head;
		ListNode secondHead = cur.next;
		cur.next = null;

		firstHead = sortList(firstHead);
		secondHead = sortList(secondHead);

		ListNode resultHead = null;
		ListNode resultTail = null;

		while (firstHead != null && secondHead != null) {
			if (firstHead.val < secondHead.val) {
				if (resultHead == null) {
					resultHead = firstHead;
				} else {
					resultTail.next = firstHead;
				}
				resultTail = firstHead;
				firstHead = firstHead.next;
			} else {
				if (resultHead == null) {
					resultHead = secondHead;
				} else {
					resultTail.next = secondHead;
				}
				resultTail = secondHead;
				secondHead = secondHead.next;
			}
		}

		while (firstHead != null) {
			resultTail.next = firstHead;
			resultTail = resultTail.next;
			firstHead = firstHead.next;
		}

		while (secondHead != null) {
			resultTail.next = secondHead;
			resultTail = resultTail.next;
			secondHead = secondHead.next;
		}

		return resultHead;
	}
}
