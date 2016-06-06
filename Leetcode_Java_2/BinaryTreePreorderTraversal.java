public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null){
        	return res;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);

		while(!nodeStack.isEmpty()){
        	
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