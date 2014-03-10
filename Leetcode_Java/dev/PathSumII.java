package hack.leetcode.dev;

import hack.leetcode.ulti.TreeNode;

import java.util.ArrayList;

/*
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *	For example:
 *	Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

 *	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 */

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pathList = new ArrayList<Integer>();
		preOrder(root, sum, res, pathList);
		
		return res;
	}
	
	private void preOrder(TreeNode node, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> pathList){
		if(node == null){
			return;
		}
		ArrayList<Integer> curPath = new ArrayList<Integer>(pathList);
		curPath.add(node.val);
		if(node.left == null && node.right == null){
			int tmpSum = 0;
			for(Integer i : curPath){
				tmpSum += i.intValue();
			}
			if(tmpSum == sum){
				res.add(curPath);
			}
			return;
		}
		preOrder(node.left, sum, res, curPath);
		preOrder(node.right, sum, res, curPath);
	}
}
