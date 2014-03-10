public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        if(root.left == null && root.right == null){
        	return 1;
        }else{
			int leftDepth = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
			int rightDepth = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
			return 1 + Math.min(leftDepth, rightDepth);
        }
    }
}
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    }
}