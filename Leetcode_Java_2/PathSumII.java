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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(root == null){
        	return res;
        }

        int sumTo = 0;

        helper(res, new ArrayList<Integer>(), sumTo, sum, root);

        return res;
    }

	private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int sumTo, int sum, TreeNode node){
		if(node == null){
			return ;
		}

		ArrayList<Integer> tmpRes = new ArrayList<Integer>(tmp);
		tmpRes.add(node.val);

		if(node.left == null && node.right == null){			
			if(sumTo + node.val == sum){
				res.add(tmpRes);
				return;
			}
		}

		helper(res, tmpRes, sumTo+node.val, sum, node.left);
		helper(res, tmpRes, sumTo+node.val, sum, node.right);
    }
}