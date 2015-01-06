package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class MergekSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists == null || lists.isEmpty()) {
			return null;
		} else if (lists.size() == 1) {
			return lists.get(0);
		}

		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				if (o1.val < o2.val) {
					return -1;
				} else if (o1.val > o2.val) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);

		for (ListNode n : lists) {
			if (n != null) {
				heap.add(n);
			}
		}

		ListNode head = null;
		ListNode cur = null;

		while (!heap.isEmpty()) {
			if (head == null) {
				head = heap.poll();
				cur = head;
			} else {
				ListNode newNode = heap.poll();
				cur.next = newNode;
				cur = cur.next;
			}
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}

		return head;
	}
}
