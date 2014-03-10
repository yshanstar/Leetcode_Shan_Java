package hack.leetcode.dev;

import hack.leetcode.ulti.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
	Map<Integer, DoubleLinkedListNode> cache;
	int capacity;
	DoubleLinkedListNode head;
	DoubleLinkedListNode tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<Integer, DoubleLinkedListNode>();
		head = new DoubleLinkedListNode(-1, -1);
		tail = new DoubleLinkedListNode(-2, -2);
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}

		DoubleLinkedListNode cur = cache.get(key);
		cur.pre.next = cur.next;
		cur.next.pre = cur.pre;
		attach(cur);
		return cur.val;
	}

	public void set(int key, int value) {
		if (cache.containsKey(key)) {
			DoubleLinkedListNode cur = cache.get(key);
			cur.val = value;
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			attach(cur);
		} else {
			if (cache.size() == capacity) {
				dettach();
			}
			DoubleLinkedListNode cur = new DoubleLinkedListNode(key, value);
			attach(cur);
			cache.put(key, cur);
		}
	}

	private void attach(DoubleLinkedListNode cur) {
		cur.next = head.next;
		cur.next.pre = cur;
		head.next = cur;
		cur.pre = head;
	}

	private void dettach() {
		DoubleLinkedListNode last = tail.pre;
		last.pre.next = last.next;
		last.next.pre = last.pre;
		cache.remove(last.key);
	}

}
