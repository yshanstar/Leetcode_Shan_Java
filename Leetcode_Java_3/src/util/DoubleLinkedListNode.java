package util;

public class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode next;
	public DoubleLinkedListNode prev;

	public DoubleLinkedListNode(int key, int value) {
		this.key = key;
		this.val = value;

		this.next = null;
		this.prev = null;
	}
}
