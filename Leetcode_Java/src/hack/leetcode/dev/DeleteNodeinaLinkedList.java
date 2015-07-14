package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeinaLinkedList {
	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}

		while (node.next != null) {
			ListNode next = node.next;
			node.val = next.val;

			if (next.next == null) {
				node.next = null;
			} else {
				node = node.next;
			}
		}
	}
}
