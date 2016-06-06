package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
public class SerializeandDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helperSerialize(root, sb);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] vals = data.split("[,]");
		int[] index = new int[] { 0 };
		TreeNode root = helperDeSerialize(vals, index);

		return root;
	}

	private void helperSerialize(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("#").append(",");
			return;
		}
		sb.append(node.val).append(",");
		helperSerialize(node.left, sb);
		helperSerialize(node.right, sb);
	}

	private TreeNode helperDeSerialize(String[] vals, int[] index) {
		if (index[0] == vals.length) {
			return null;
		}

		String visiting = vals[index[0]++];
		if (visiting.equals("#")) {
			return null;
		}

		TreeNode node = new TreeNode(Integer.valueOf(visiting));
		node.left = helperDeSerialize(vals, index);
		node.right = helperDeSerialize(vals, index);

		return node;
	}

	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree test = new SerializeandDeserializeBinaryTree();
		test.deserialize("[]");
	}
}
