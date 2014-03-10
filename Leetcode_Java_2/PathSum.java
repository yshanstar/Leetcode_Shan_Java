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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null ){
        	return false;
        }

        if(root.left == null && root.right == null){
        	return (root.val == sum);
        }

        int target = root.val;

        return helper(target, root.left, sum) || helper(target, root.right, sum);
    }

    private boolean helper(int sumTo, TreeNode node, int sum){
    	if(node == null){
    		return false;
    	}
    	if(node.left == null && node.right == null){
    		return ((sumTo + node.val) == sum);
    	}

    	return helper(sumTo+node.val, node.left, sum) || helper(sumTo+node.val, node.rihgt, sum);
    }
}