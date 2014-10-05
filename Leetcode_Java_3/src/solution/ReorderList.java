package solution;

import java.util.Stack;

import util.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode tail = head;
		ListNode mid = head;
		while (tail.next != null) {
			tail = tail.next;
			if (tail.next != null) {
				tail = tail.next;
			} else {
				break;
			}
			mid = mid.next;
		}

		ListNode tmp = mid.next;
		mid.next = null;
		Stack<ListNode> nodeStack = new Stack<ListNode>();
		while (tmp != null) {
			nodeStack.add(tmp);
			tmp = tmp.next;
		}

		tail = head;
		while (tail != null) {
			if (nodeStack.isEmpty()) {
				break;
			}
			ListNode n = nodeStack.pop();
			n.next = tail.next;
			tail.next = n;
			tail = n.next;
		}

		while (!nodeStack.isEmpty()) {
			ListNode n = nodeStack.pop();
			n.next = tail.next;
			tail.next = n;
			tail = n;
		}
	}
}
