package util;

/*
 * Binary Indexed TreeNode
 */
public class BITreeNode {
	public int idx;
	public int value;

	public BITreeNode(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.idx + ": " + this.value);
		return sb.toString();
	}
}
