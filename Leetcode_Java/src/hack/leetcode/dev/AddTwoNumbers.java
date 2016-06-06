package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of 
 * their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode curL1 = l1;
		ListNode curL2 = l2;
		ListNode res = null;
		ListNode resHead = res;
		int next = 0;

		while (curL1 != null && curL2 != null) {
			int l1Value = curL1.val;
			int l2Value = curL2.val;
			int sum = l1Value + l2Value + next;
			next = sum / 10;
			if (res == null) {
				res = new ListNode(sum % 10);
				resHead = res;
			} else {
				res.next = new ListNode(sum % 10);
				res = res.next;
			}
			curL1 = curL1.next;
			curL2 = curL2.next;
		}

		while (curL1 != null) {
			int l1Value = curL1.val;
			int sum = l1Value + next;
			next = sum / 10;
			res.next = new ListNode(sum % 10);
			res = res.next;
			curL1 = curL1.next;
		}

		while (curL2 != null) {
			int l2Value = curL2.val;
			int sum = l2Value + next;
			next = sum / 10;
			res.next = new ListNode(sum % 10);
			res = res.next;
			curL2 = curL2.next;
		}

		if (next != 0) {
			res.next = new ListNode(next % 10);
			res = res.next;
		}

		return resHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);

		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(3);
		n2.next = n3;

		ListNode res = addTwoNumbers(n1, n2);
		System.out.println(res);
	}
}
