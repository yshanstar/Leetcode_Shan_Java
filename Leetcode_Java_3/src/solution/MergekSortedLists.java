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

	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode head = null;
		ListNode prev = head;

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.length, new ListNodeComparator());

		for (ListNode listHead : lists) {
			if (listHead != null) {
				heap.offer(listHead);
			}
		}

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

	class ListNodeComparator implements Comparator<ListNode> {
		public int compare(ListNode n1, ListNode n2) {
			return n1.val - n2.val;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;

		ListNode[] lists = new ListNode[] { n1 };

		MergekSortedLists test = new MergekSortedLists();
		test.mergeKLists2(lists);
	}
}
