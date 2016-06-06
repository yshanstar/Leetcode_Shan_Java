/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int res = 0;
		if(root == null){
        	return res;
        }else if (root.left == null && root.right == null){
        	return root.val;
        }

        Sum maxSum = new Sum(Integer.MIN_VALUE);
        Sum tmpSum = new Sum(0);
       	getMaxSumHelper(maxSum, tmpSum, root);

       	return maxSum.val;

    }

    private void getMaxSumHelper(Sum maxSum, Sum tmpSum, TreeNode node){
    	if(node == null){
    		tmpSum = new Sum(0);
    		return;
    	}

    	Sum leftSum = new Sum(0);
    	Sum rightSum = new Sum(0);

    	getMaxSumHelper(maxSum, leftSum, node.left);
    	getMaxSumHelper(maxSum, rightSum, node.right);

    	tmpSum.val = Math.max(node.val, Math.max(leftSum.val, rightSum.val) + node.val);
    	maxSum.val = Math.max(maxSum.val, Math.max(tmpSum.val, node.val + leftSum.val + rightSum.val));
    }
}
class Sum{
	int val;
	public Sum(int m){
		this.val = m;
	}
}