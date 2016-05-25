package solution;

import java.util.Arrays;

import util.BITreeNode;

/*
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * 
 * Let us consider the following problem to understand Binary Indexed Tree.

We have an array arr[0 . . . n-1]. We should be able to
1 Find the sum of first i elements.
2 Change value of a specified element of the array arr[i] = x where 0 <= i <= n-1.

A simple solution is to run a loop from 0 to i-1 and calculate sum of elements. To update a value, simply do arr[i] = x. The first operation takes O(n) time and second operation takes O(1) time. Another simple solution is to create another array and store sum from start to i at the i¡¯th index in this array. Sum of a given range can now be calculated in O(1) time, but update operation takes O(n) time now. This works well if the number of query operations are large and very few updates.

Can we perform both the operations in O(log n) time once given the array? 
One Efficient Solution is to use Segment Tree that does both operations in O(Logn) time.

Using Binary Indexed Tree, we can do both tasks in O(Logn) time. The advantages of Binary Indexed Tree over Segment are, requires less space and very easy to implement..

Representation
Binary Indexed Tree is represented as an array. Let the array be BITree[]. Each node of Binary Indexed Tree stores sum of some elements of given array. Size of Binary Indexed Tree is equal to n where n is size of input array. In the below code, we have used size as n+1 for ease of implementation.

Construction
We construct the Binary Indexed Tree by first initializing all values in BITree[] as 0. Then we call update() operation for all indexes to store actual sums, update is discussed below.
 */
public class BinaryIndexedTree {
	public BITreeNode[] buildBITree(int[] nums) {
		BITreeNode[] BITree = new BITreeNode[nums.length + 1];

		for (int i = 0; i < BITree.length; i++) {
			BITree[i] = new BITreeNode(i, 0);
		}

		for (int i = 0; i < nums.length; i++) {
			updateBIT(BITree, nums.length, i, nums[i]);
		}

		return BITree;
	}

	public void updateBIT(BITreeNode[] BITree, int n, int idx, int value) {
		int index = idx + 1;
		while (index <= n) {
			BITree[index].value += value;
			index += index & (-index);
		}
	}

	public int getSum(BITreeNode[] BITree, int idx) {
		int index = idx + 1;
		int sum = 0;
		while (index > 0) {
			sum += BITree[index].value;
			index -= index & (-index);
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		BinaryIndexedTree Bit = new BinaryIndexedTree();
		BITreeNode[] BITree = Bit.buildBITree(nums);

		for (BITreeNode node : BITree) {
			System.out.println(node.toString());
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(Bit.getSum(BITree, i) + "\t");
		}

		int tmp = nums[5];
		nums[5] = -10;

		Bit.updateBIT(BITree, nums.length, 5, nums[5] - tmp);
		for (BITreeNode node : BITree) {
			System.out.println(node.toString());
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(Bit.getSum(BITree, i) + "\t");
		}
		
		
		int[] nums2 = new int[] { -2, 5, -1 };
		BITree = Bit.buildBITree(nums2);
		for (BITreeNode node : BITree) {
			System.out.println(node.toString());
		}
	}
}
