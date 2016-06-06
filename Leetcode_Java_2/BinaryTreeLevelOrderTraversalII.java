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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null){
        	return new ArrayList<ArrayList<Integer>>();
        }

        Stack<ArrayList<Integer>> levelNodes = new Stack<ArrayList<Integer>>();

        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        ArrayList<Integer> curValues = new ArrayList<Integer>();

        cur.add(root);

        while(!cur.isEmpty()){
        	TreeNode tmp = cur.poll();
        	if(tmp.left != null){
        		next.offer(tmp.left);
        	}
        	if(tmp.right != null){
        		next.offer(tmp.right);
        	}
        	curValues.add(tmp.val);

        	if(cur.isEmpty()){
        		levelNodes.push(curValues);
        		curValues = new ArrayList<Integer>();
        		cur = next;
        		next = new LinkedList<TreeNode>();
        	}
        }


        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        while(!levelNodes.isEmpty()){
			res.add(levelNodes.pop());
        }

        return res;
    }
}