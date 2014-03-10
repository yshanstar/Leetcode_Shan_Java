package hack.leetcode.ulti;

public class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;

	public DoubleLinkedListNode(int key, int value) {
		this.key = key;
		this.val = value;
		next = null;
		pre = null;
	}
}
