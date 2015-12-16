package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

public class TwoSumInBST {
	boolean bstTwoSum(TreeNode root, int target) {
		if (root == null)
			return false;
		return leftdfs(root, root, target);
	}

	boolean leftdfs(TreeNode n, TreeNode root, int target) { // n=1, root=5,
																// target = 10
		if (n == null)
			return false;
		if (n.left != null)
			if (leftdfs(n.left, root, target))
				return true;
		if (rightdfs(root, target - n.val))
			return true;//
		if (n.right != null)
			if (leftdfs(n.right, root, target))
				return true;
		
		return false;
	}

	boolean rightdfs(TreeNode n, int target) {// n=9, target=9
		if (n == null)
			return false;
		if (n.right != null)
			if (rightdfs(n.right, target))
				return true;
		if (n.val == target)
			return true;
		if (n.val < target)
			return false;
		if (n.left != null)
			if (rightdfs(n.left, target))
				return true;
		
		return false;
	}
	
	public static void main(String[] args){
		TwoSumInBST t = new TwoSumInBST();
		
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(10);
		TreeNode n6 = new TreeNode(1);
		
		
		n1.left = n2;
		n1.right = n3;
		
		n3.left = n4;
		n3.right = n5;
		
		n2.left = n6;
		
		System.out.println(t.bstTwoSum(n1, 5));
	}
}
