package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.management.MXBean;

import util.TreeNode;

/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */
public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(root == null){
			return res;
		}
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<Integer> colQueue = new LinkedList<Integer>();
		
		nodeQueue.offer(root);
		colQueue.offer(0);
		int minCol  = 0;
		int maxCol = 0;
		
		while(!nodeQueue.isEmpty()){
			TreeNode node = nodeQueue.poll();
			int col = colQueue.poll();
			
			if(!map.containsKey(col)){
				map.put(col, new ArrayList<Integer>());
			}
			
			map.get(col).add(node.val);

			if (node.left != null) {
				nodeQueue.offer(node.left);
				colQueue.offer(col - 1);

				if (col - 1 < minCol) {
					minCol = col - 1;
				}
			}

			if (node.right != null) {
				nodeQueue.offer(node.right);
				colQueue.offer(col + 1);

				if (col + 1 > maxCol) {
					maxCol = col + 1;
				}
			}
		}
		
		for(int i = minCol; i<=maxCol; i++){
			res.add(map.get(i));
		}
		
		return res;
	}
}
