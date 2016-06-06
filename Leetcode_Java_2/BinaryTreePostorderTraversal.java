public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
        	return res;
        }
        Stack<TreeNode> first = new Stack<TreeNode>();
        Stack<TreeNode> second = new Stack<TreeNode>();

        first.push(root);

        while(!first.isEmpty()){
        	TreeNode tmp = first.pop();

        	if(tmp.left != null){
				first.push(tmp.left);
        	}

        	if(tmp.right != null){
        		first.push(tmp.right);
        	}

			second.push(tmp);
        }

        while(!second.isEmpty()){
			res.add(second.pop().val);
        }

        return res;
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