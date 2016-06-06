package solution;

import java.util.HashMap;
import java.util.Map;

import util.DoubleLinkedListNode;

public class LRUCache {
	int capacity;
	Map<Integer, DoubleLinkedListNode> cache;
	DoubleLinkedListNode head;
	DoubleLinkedListNode tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<Integer, DoubleLinkedListNode>();
		head = new DoubleLinkedListNode(-1, -1);
		tail = new DoubleLinkedListNode(-2, -2);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}
		DoubleLinkedListNode cur = cache.get(key);
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		attach(cur);
		return cur.val;
	}

	public void set(int key, int value) {
		if (!cache.containsKey(key)) {
			if (cache.size() == capacity) {
				dettach();
			}
			DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
			attach(node);
			cache.put(key, node);
		} else {
			DoubleLinkedListNode cur = cache.get(key);
			cur.val = value;
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			attach(cur);
		}
	}

	private void dettach() {
		DoubleLinkedListNode last = tail.prev;
		last.prev.next = tail;
		tail.prev = last.prev;
		last.next = null;
		last.prev = null;
		cache.remove(last.key);
	}

	private void attach(DoubleLinkedListNode node) {
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
		node.prev = head;
	}
}
