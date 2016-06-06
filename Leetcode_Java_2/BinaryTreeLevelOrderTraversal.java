public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root == null){
			return res;
        }

        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        ArrayList<Integer> tmpRes = new ArrayList<Integer>();
        cur.offer(root);

        while(!cur.isEmpty()){
        	TreeNode tmp = cur.poll();
        	tmpRes.add(tmp.val);

        	if(tmp.left != null){
        		next.offer(tmp.left);
        	}

        	if(tmp.right != null){
        		next.offer(tmp.right);
        	}

        	if(cur.isEmpty()){
        		res.add(tmpRes);
        		cur = next;
        		next = new LinkedList<TreeNode>();
				tmpRes = new ArrayList<Integer>();
        	}
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