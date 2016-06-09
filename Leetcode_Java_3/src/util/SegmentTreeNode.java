package util;

public class SegmentTreeNode {
	public int sum;
	public SegmentTreeNode left;
	public SegmentTreeNode right;
	public int start;
	public int end;

	public SegmentTreeNode(int s, int e) {
		this.start = s;
		this.end = e;
		this.sum = 0;
		this.left = null;
		this.right = null;
	}
}
