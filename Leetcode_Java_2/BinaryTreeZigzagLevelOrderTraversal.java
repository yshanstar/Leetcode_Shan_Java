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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
        	return res;
        }

        ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
        curLevel.add(root);

        boolean isOdd = true;

        while(!curLevel.isEmpty()){
			ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
			ArrayList<Integer> curValue = new ArrayList<Integer>();
			for(TreeNode n : curLevel){
				curValue.add(n.val);
			}
			res.add(curValue);

			for(int i = curLevel.size()-1; i>=0; i--){
				TreeNode n = curLevel.get(i);
				if(isOdd){
					if(n.right != null){
						nextLevel.add(n.right);
					}

					if(n.left != null){
						nextLevel.add(n.left);
					}
				}else{
					if(n.left != null){
						nextLevel.add(n.left);
					}
					if(n.right != null){
						nextLevel.add(n.right);
					}
				}
			}

			isOdd = isOdd ? false : true;
			curLevel = new ArrayList<TreeNode>(nextLevel);
        }

        return res;
    }
}