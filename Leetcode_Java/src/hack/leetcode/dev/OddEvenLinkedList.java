package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input. 
 The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode oddHead = head;
		ListNode odd = oddHead;
		ListNode evenHead = head.next;
		ListNode even = evenHead;

		ListNode cur = even.next;
		int count = 3;
		oddHead.next = null;
		evenHead.next = null;

		while (cur != null) {
			ListNode tmp = cur;
			cur = cur.next;
			tmp.next = null;

			if (count % 2 == 1) {
				odd.next = tmp;
				odd = odd.next;
			} else {
				even.next = tmp;
				even = even.next;
			}

			count++;
		}

		if (evenHead != null) {
			odd.next = evenHead;
		}

		return oddHead;
	}
}
