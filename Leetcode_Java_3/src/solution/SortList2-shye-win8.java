package solution;

import util.ListNode;

public class SortList2 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = head;
		ListNode tmp = head.next;

		while (tmp != null && tmp.next != null) {
			mid = mid.next;
			tmp = tmp.next.next;
		}

		ListNode head2 = mid.next;
		mid.next = null;

		head = sortList(head);
		head2 = sortList(head2);

		return merge(head, head2);
	}

	private ListNode merge(ListNode node1, ListNode node2) {
		if (node1 == null && node2 == null) {
			return null;
		}

		if (node1 == null) {
			return node2;
		}

		if (node2 == null) {
			return node1;
		}

		ListNode tmp = new ListNode(-1);
		ListNode cur = tmp;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				cur.next = node1;
				node1 = node1.next;
			} else {
				cur.next = node2;
				node2 = node2.next;
			}
			cur = cur.next;
		}

		while (node1 != null) {
			cur.next = node1;
			node1 = node1.next;
			cur = cur.next;
		}

		while (node2 != null) {
			cur.next = node2;
			node2 = node2.next;
			cur = cur.next;
		}

		return tmp.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		SortList2 test = new SortList2();
		ListNode result = test.sortList(node1);
		
		System.out.println(result.val);
	}
}
