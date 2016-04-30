package solution;

import java.util.HashMap;
import java.util.Map;

import util.DoubleLinkedListNode;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class Cache {
	int capacity;
	DoubleLinkedListNode head;
	DoubleLinkedListNode tail;
	Map<Integer, DoubleLinkedListNode> map;

	public Cache(int capacity) {
		this.capacity = capacity;
		head = new DoubleLinkedListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
		tail = new DoubleLinkedListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
		head.next = tail;
		tail.prev = head;

		map = new HashMap<Integer, DoubleLinkedListNode>();

	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode node = map.get(key);
			node.prev.next = node.next;
			node.next.prev = node.prev;
			addNode(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (!map.containsKey(key)) {
			if (map.size() == capacity) {
				remove();
			}
			DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
			addNode(node);
			map.put(key, node);
		} else {
			DoubleLinkedListNode node = map.get(key);
			node.val = value;
			node.prev.next = node.next;
			node.next.prev = node.prev;
			addNode(node);
		}
	}

	private void remove() {
		DoubleLinkedListNode last = tail.prev;
		last.prev.next = tail;
		tail.prev = last.prev;
		last.next = null;
		last.prev = null;
		map.remove(last.key);
	}

	private void addNode(DoubleLinkedListNode node) {
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
		node.prev = head;
	}
}
