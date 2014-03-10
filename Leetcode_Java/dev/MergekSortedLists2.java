package hack.leetcode.dev;

import hack.leetcode.ulti.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Merge k Sorted Lists
 */
public class MergekSortedLists2 {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
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

		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), comparator);

		for (ListNode n : lists) {
			if (n != null) {
				minHeap.add(n);
			}
		}

		ListNode head = null;
		ListNode cur = null;

		while (!minHeap.isEmpty()) {
			if (head == null) {
				head = minHeap.poll();
				cur = head;
			} else {
				ListNode newNode = minHeap.poll();
				cur.next = newNode;
				cur = cur.next;
			}
			if (cur.next != null) {
				minHeap.add(cur.next);
			}
		}
		return head;
	}
}
