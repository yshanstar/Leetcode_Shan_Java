public class Solution {
    public int maxPathSum(TreeNode root) {
    	int res = 0;
    	if(root == null){
    		return res;
    	}

    	if(root.left == null && root.right == null){
    		return root.val;
    	}

    	Sum maxSum = new Sum(Integer.MIN_VALUE);
    	Sum tmpSum = new Sum(0);

    	getMaxSumHelper(root, maxSum, tmpSum);

    	return maxSum.val;

    }

    private void getMaxSumHelper(TreeNode node, Sum maxSum, Sum tmpSum){
    	if(node == null){
    		tmpSum = new Sum(0);
    		return;
    	}

    	Sum leftSum = new Sum(0);
    	Sum rightSum = new Sum(0);

    	getMaxSumHelper(node.left, maxSum, leftSum);
    	getMaxSumHelper(node.right, maxSum, rightSum);

    	tmpSum.val = Math.max(node.val, Math.max(leftSum.val, rightSum.val) + node.val);
    	maxSum.val = Math.max(maxSum.val, Math.max(tmpSum.val, node.val + leftSum.val + rightSum.val));
    }
}
class Sum{
	int val;
	public Sum(int v){
		this.val = v;
	}
}