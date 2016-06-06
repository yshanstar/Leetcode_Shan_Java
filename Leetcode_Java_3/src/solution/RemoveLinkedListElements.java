package solution;

import util.ListNode;

/*
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode newHead = new ListNode(Integer.MAX_VALUE);
		newHead.next = head;

		ListNode cur = head;
		ListNode prev = newHead;
		while (cur != null) {
			if (cur.val == val) {
				cur = cur.next;
				prev.next = cur;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}

		return newHead.next;
	}
	
	public static void main(String[] args){
		RemoveLinkedListElements test = new RemoveLinkedListElements();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		
		ListNode tmp = test.removeElements(node1, 2);
	}
}
