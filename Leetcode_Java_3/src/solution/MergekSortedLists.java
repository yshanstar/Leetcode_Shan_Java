package solution;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import util.ListNode;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), new Comparator<ListNode>() {
					public int compare(ListNode n1, ListNode n2) {
						return n1.val - n2.val;
					}
				});

		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if (node != null) {
				heap.offer(node);
			}
		}

		ListNode head = null;
		ListNode prev = head;

		while (heap.size() > 0) {
			ListNode cur = heap.poll();
			if (head == null) {
				head = cur;
				prev = head;
			} else {
				prev.next = cur;
			}
			prev = cur;
			if (cur.next != null) {
				heap.offer(cur.next);
			}
		}

		return head;
	}
}
